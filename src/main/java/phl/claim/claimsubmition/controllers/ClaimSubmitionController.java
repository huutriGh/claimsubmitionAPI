package phl.claim.claimsubmition.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import phl.claim.claimsubmition.models.ClaimSubmition;
import phl.claim.claimsubmition.models.ImagePath;
import phl.claim.claimsubmition.services.ClaimsumitionService;

@RestController
public class ClaimSubmitionController {
    private ClaimsumitionService claimsumitionService;

    @Autowired
    public ClaimSubmitionController(ClaimsumitionService claimsumitionService) {
        this.claimsumitionService = claimsumitionService;
    }

    @RequestMapping(value = "/claimsumitions/{poNumber}/{laIdNumber}", method = RequestMethod.GET)
    public ResponseEntity<List<ClaimSubmition>> findAllProduct(@PathVariable("poNumber") String poNumber,
            @PathVariable("laIdNumber") String laIdNumber) {

        List<ClaimSubmition> claimSubmition = claimsumitionService.findAll(poNumber, laIdNumber);
        if (claimSubmition == null || claimSubmition.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(claimSubmition, HttpStatus.OK);
    }

    @RequestMapping(value = "/claimsumitions/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClaimSubmition> getProductById(@PathVariable("id") Integer id) {
        ClaimSubmition claimSubmition = claimsumitionService.findById(id);
        if (claimSubmition.getPoNumber() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(claimSubmition, HttpStatus.OK);

    }

    @RequestMapping(value = "/claimsumitions", method = RequestMethod.POST)
    public ResponseEntity<ClaimSubmition> createProuct(@RequestBody ClaimSubmition claimSubmition,
            UriComponentsBuilder builder) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String a = formatter.format(date);
        try {
            claimSubmition.setDateSubmit(formatter.parse(a));
        } catch (ParseException e) {

            e.printStackTrace();
        }
        claimsumitionService.save(claimSubmition);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/products/{id}").buildAndExpand(claimSubmition.getId()).toUri());
        return new ResponseEntity<>(claimSubmition, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/claimsumitions/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ClaimSubmition> updateProduct(@PathVariable("id") Integer id,
            @RequestBody ClaimSubmition claimsumition) {
        ClaimSubmition currentClaimsumition = claimsumitionService.findById(id);

        if (currentClaimsumition.getPoNumber() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            currentClaimsumition.setAccountHolder(claimsumition.getAccountHolder());
            currentClaimsumition.setAccountIdCard(claimsumition.getAccountIdCard());
            currentClaimsumition.setAccountIdCardDate(claimsumition.getAccountIdCardDate());
            currentClaimsumition.setAccountName(claimsumition.getAccountName());
            currentClaimsumition.setAccountNumber(claimsumition.getAccountNumber());
            currentClaimsumition.setBenifitType(claimsumition.getBenifitType());
            currentClaimsumition.setDateIn(claimsumition.getDateIn());
            currentClaimsumition.setDateOut(claimsumition.getDateOut());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date date = new Date();
            String a = formatter.format(date);
            try {
                currentClaimsumition.setDateUpdate(formatter.parse(a));
            } catch (ParseException e) {

                e.printStackTrace();
            }
            currentClaimsumition.setDiagonostic(claimsumition.getDiagonostic());
            currentClaimsumition.setDoctor(claimsumition.getDoctor());
            currentClaimsumition.setEventDate(claimsumition.getEventDate());
            currentClaimsumition.setEventDiscription(claimsumition.getEventDiscription());
            currentClaimsumition.setEventPlace(claimsumition.getEventPlace());
            currentClaimsumition.setEventReason(claimsumition.getEventReason());
            currentClaimsumition.setHospital(claimsumition.getHospital());
            currentClaimsumition.setHospitalHealthIns(claimsumition.getHospitalHealthIns());
            currentClaimsumition.setIsr1Amount(claimsumition.getIsr1Amount());
            currentClaimsumition.setIsr1EffDate(claimsumition.getIsr1EffDate());
            currentClaimsumition.setIsr1Name(claimsumition.getIsr1Name());
            currentClaimsumition.setIsr2Amount(claimsumition.getIsr2Amount());
            currentClaimsumition.setIsr2EffDate(claimsumition.getIsr2EffDate());
            currentClaimsumition.setIsr2Name(claimsumition.getIsr2Name());
            currentClaimsumition.setLaAddress(claimsumition.getLaAddress());
            currentClaimsumition.setLaIdNumber(claimsumition.getLaIdNumber());
            currentClaimsumition.setLaName(claimsumition.getLaName());
            currentClaimsumition.setLaPhone(claimsumition.getLaPhone());
            currentClaimsumition.setOrtherInsurance(claimsumition.getOrtherInsurance());
            currentClaimsumition.setPaymentMothod(claimsumition.getPaymentMothod());
            currentClaimsumition.setRqAddress(claimsumition.getRqAddress());
            currentClaimsumition.setRqIdNumber(claimsumition.getRqIdNumber());
            currentClaimsumition.setRqName(claimsumition.getRqName());
            currentClaimsumition.setRqPhone(claimsumition.getRqPhone());

            claimsumitionService.save(currentClaimsumition);
            return new ResponseEntity<>(currentClaimsumition, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/claimsumitions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ClaimSubmition> deleteProduct(@PathVariable("id") Integer id) {
        ClaimSubmition claimSubmition = claimsumitionService.findById(id);
        if (claimSubmition.getPoNumber() != null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String a = formatter.format(date);
        try {
            claimSubmition.setDateDelete(formatter.parse(a));
        } catch (ParseException e) {

            e.printStackTrace();
        }
        claimsumitionService.save(claimSubmition);
        return new ResponseEntity<>(claimSubmition, HttpStatus.NO_CONTENT);
    }

    @Value("${app.fileBasePath}")
    String testPath;

    public ResponseEntity<ImagePath> uploadToLocalFileSystem(@RequestParam("file") MultipartFile file, String claimId,
            String typeImage) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        System.out.println(testPath);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        Date date = new Date();
        String a = formatter.format(date);

        Path dirPathObj = Paths.get("Images" + "\\" + a + "\\" + claimId + "\\" + typeImage + "\\");
        boolean dirExists = Files.exists(dirPathObj);
        if (dirExists) {
            System.out.println("! Directory Already Exists !");
        } else {
            try {
                // Creating The New Directory Structure
                Files.createDirectories(dirPathObj);
                System.out.println("! New Directory Successfully Created !");
            } catch (IOException ioExceptionObj) {
                System.out.println(
                        "Problem Occured While Creating The Directory Structure= " + ioExceptionObj.getMessage());
            }
        }

        Path path = Paths.get(dirPathObj + "\\" + fileName);
        // System.out.println(path.toString());
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        // .path(path.toString().replace('\\', '/')).toUriString();
        return ResponseEntity.ok(new ImagePath(path.toString().replace("\\\\", "\\"), typeImage));
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public ResponseEntity<HashSet<ImagePath>> uploadImage(@RequestParam("files") MultipartFile[] files,
            @RequestParam("claimId") String claimId, @RequestParam("typeImage") String typeImage) {
        HashSet<ImagePath> fileDownloadUrls = new HashSet<>();
        for (MultipartFile file : files) {
            fileDownloadUrls.add(uploadToLocalFileSystem(file, claimId, typeImage).getBody());
        }
        // Arrays.asList(files).stream()
        // .forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file, claimId,
        // typeImage).getBody()));
        return ResponseEntity.ok(fileDownloadUrls);
    }

    @RequestMapping(value = "/Images/{folder}/{date}/{claimId}/{typeId}/{fileName}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getImage(@PathVariable("folder") String folder, @PathVariable("date") String date,
            @PathVariable("claimId") String claimId, @PathVariable("typeId") String typeId,
            @PathVariable("fileName") String fileName) {
        Path path = Paths.get(folder + "\\" + date + "\\" + claimId + "\\" + typeId + "\\" + fileName);
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @RequestMapping(value = "/ImagePath/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Integer> updateImagePath(@PathVariable("id") Integer id, @RequestBody ImagePath imagePath) {
        if (claimsumitionService.updateImagePath(id, imagePath.getPath()) > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(0);
        }
    }
}