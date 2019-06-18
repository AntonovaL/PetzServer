package com.petz.server.controller;

import com.petz.server.entity.Animal;
import com.petz.server.entity.UserData;
import com.petz.server.requests.AnimalForm;
import com.petz.server.responses.AnimalResponceToOwner;
import com.petz.server.responses.AnimalResponseToClient;
import com.petz.server.security.services.UserPrinciple;
import com.petz.server.service.AnimalService;
import com.petz.server.service.UserDataService;
import com.petz.server.service.UserService;
import com.petz.server.tools.RandomString;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import sun.misc.IOUtils;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

        //private final StorageService storageService;
        private RandomString randomString=new RandomString();
        @Autowired
        private UserService userService;
        @Autowired
        private AnimalService animalService;
        @Autowired
        private UserDataService userDataService;


        @PostMapping("/add")
        public ResponseEntity<String> addAnimal(@Valid @RequestBody AnimalForm animalForm) {
            UserPrinciple user=(UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int id=user.getId();
            Animal animal=new Animal();
            animal.setOwnerId(id);
            animal.setAge(Float.parseFloat(animalForm.getAge()));
            animal.setInfo(animalForm.getInfo());
            animal.setName(animalForm.getName());
            animal.setType(animalForm.getType());
            animal.setSex(animalForm.getSex());
            //saveFILE
            byte[] byteArray= Base64.decodeBase64(animalForm.getFile());
            String path=String.valueOf(id)+"_"+randomString.nextString()+".jpeg";
            animal.setPhoto(path);
            OutputStream out = null;
            try {
                out = new BufferedOutputStream(new FileOutputStream("../images/"+path));
                out.write(byteArray);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            int animalId=animalService.save(animal).getAnimalId();
            System.out.println(animalId);
            return ResponseEntity.ok().body(Integer.toString(animalId));
        }

        @GetMapping("/getAll")
        public ResponseEntity<?> getAll() {
            UserPrinciple user=(UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int id=user.getId();
            List<Animal> animals=animalService.getAllByOwnerId(id);
            List<AnimalResponceToOwner> response=new ArrayList<>();

            for (int i=0; i<animals.size(); i++){
                AnimalResponceToOwner resp=new AnimalResponceToOwner();
                resp.setId(animals.get(i).getAnimalId());
                resp.setName(animals.get(i).getName());
                resp.setAge(animals.get(i).getAge());
                resp.setSex(animals.get(i).getSex());
                resp.setType(animals.get(i).getType());
                resp.setInfo(animals.get(i).getInfo());
                resp.setImg(animals.get(i).getPhoto());
                response.add(resp);
            }
            return ResponseEntity.ok().body(response);
        }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAllToOwner(@PathVariable("id") int id) {
        Animal animal=animalService.getById(id);
        AnimalResponceToOwner response=new AnimalResponceToOwner();
        response.setId(animal.getAnimalId()); response.setImg(animal.getPhoto());
        response.setInfo(animal.getInfo()); response.setType(animal.getType());
        response.setSex(animal.getSex()); response.setAge(animal.getAge());
        response.setName(animal.getName());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getByTypeAndSex/{type}/{sex}")
    public ResponseEntity<?> getAnimalsByTypeAndSex(@PathVariable("type") String type,
                                        @PathVariable("sex") String sex){
        List<Animal> animals= animalService.getAllByTypeAndSex(type,sex);
        List<AnimalResponseToClient> response=new ArrayList<>();
        for (int i=0; i<animals.size()&&i<15; i++){
            AnimalResponseToClient resp=new AnimalResponseToClient();
            resp.setId(animals.get(i).getAnimalId());
            resp.setName(animals.get(i).getName());
            resp.setAge(animals.get(i).getAge());
            resp.setSex(animals.get(i).getSex());
            resp.setType(animals.get(i).getType());
            resp.setInfo(animals.get(i).getInfo());
            resp.setImg(animals.get(i).getPhoto());
            UserData ud=userDataService.getById(animals.get(i).getOwnerId());
            resp.setPhoneNumber(ud.getPhoneNumber());
            resp.setOwnerName(ud.getName());
            response.add(resp);
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getByType/{type}")
    public ResponseEntity<?> getAnimalsByType(@PathVariable("type") String type)
    {
        List<Animal> animals= animalService.getAllByType(type);
        List<AnimalResponseToClient> response=new ArrayList<>();
        for (int i=0; i<animals.size()&&i<15; i++){
            AnimalResponseToClient resp=new AnimalResponseToClient();
            resp.setId(animals.get(i).getAnimalId());
            resp.setName(animals.get(i).getName());
            resp.setAge(animals.get(i).getAge());
            resp.setSex(animals.get(i).getSex());
            resp.setType(animals.get(i).getType());
            resp.setInfo(animals.get(i).getInfo());
            resp.setImg(animals.get(i).getPhoto());
            UserData ud=userDataService.getById(animals.get(i).getOwnerId());
            resp.setPhoneNumber(ud.getPhoneNumber());
            resp.setOwnerName(ud.getName());
            response.add(resp);
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getBySex/{sex}")
    public ResponseEntity<?> getAnimalsBySex(@PathVariable("sex") String sex){
        List<Animal> animals= animalService.getAllBySex(sex);
        List<AnimalResponseToClient> response=new ArrayList<>();
        for (int i=0; i<animals.size()&&i<15; i++){
            AnimalResponseToClient resp=new AnimalResponseToClient();
            resp.setId(animals.get(i).getAnimalId());
            resp.setName(animals.get(i).getName());
            resp.setAge(animals.get(i).getAge());
            resp.setSex(animals.get(i).getSex());
            resp.setType(animals.get(i).getType());
            resp.setInfo(animals.get(i).getInfo());
            resp.setImg(animals.get(i).getPhoto());
            UserData ud=userDataService.getById(animals.get(i).getOwnerId());
            resp.setPhoneNumber(ud.getPhoneNumber());
            resp.setOwnerName(ud.getName());
            response.add(resp);
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getByRating")
    public ResponseEntity<?> getAnimalsBySex(){
        List<Animal> animals= animalService.getAll();
        List<AnimalResponseToClient> response=new ArrayList<>();
        for (int i=0; i<animals.size()&&i<15; i++){
            AnimalResponseToClient resp=new AnimalResponseToClient();
            resp.setId(animals.get(i).getAnimalId());
            resp.setName(animals.get(i).getName());
            resp.setAge(animals.get(i).getAge());
            resp.setSex(animals.get(i).getSex());
            resp.setType(animals.get(i).getType());
            resp.setInfo(animals.get(i).getInfo());
            resp.setImg(animals.get(i).getPhoto());
            UserData ud=userDataService.getById(animals.get(i).getOwnerId());
            resp.setPhoneNumber(ud.getPhoneNumber());
            resp.setOwnerName(ud.getName());
            response.add(resp);
        }
        return ResponseEntity.ok().body(response);
    }
}
