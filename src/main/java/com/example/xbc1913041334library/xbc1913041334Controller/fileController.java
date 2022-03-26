package com.example.xbc1913041334library.xbc1913041334Controller;

import com.example.xbc1913041334library.xbc1913041334Pojo.Library;
import com.example.xbc1913041334library.xbc1913041334Service.ILibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping
public class fileController {
    @Autowired
    private ILibraryService ILibraryService;

    @GetMapping("/upload/page")
    public String uploadPage(){
        return "/library/add";
    }

    @PostMapping("/multipart")
    @ResponseBody
    public String upload(
                        @RequestParam("xbc1913041334Id") Integer xbc1913041334Id,
                        @RequestParam("xbc1913041334Name") String xbc1913041334Name,
                        @RequestParam("xbc1913041334Price") Integer xbc1913041334Price,
                        @RequestParam("pic") MultipartFile pic,
                        Model model) {
        String path="D:/photo/";
        String filename=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        log.info("filename={}",filename);
        System.out.println("filename");
//        int unixSep = filename.lastIndexOf('/');
//        int winSep = filename.lastIndexOf('\\');
//        int pos = (winSep > unixSep ? winSep : unixSep);
//        if (pos != -1)  {
//            filename = filename.substring(pos + 1);
//        }

        String tupian=pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("/"));
        String suffix=pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
        System.out.println(suffix);
        String photo=tupian;
        System.out.println(photo);
        //String photoURL=filename+suffix;
        /*Map<String,Object> map=new HashMap<String,Object>();
        map.put("photo",photoURL);*/
        if(!suffix.equals(".png")){
            dealResultMap(false,"上传失败");
        }
        try {
            FileOutputStream os=new FileOutputStream(filename+suffix);
            FileCopyUtils.copy(pic.getInputStream(),os);
           // ILibraryService.insertPhoto(xbc1913041334Id,photoURL);
            Library library=new Library();
            library.setXbc1913041334Id(xbc1913041334Id);
            library.setXbc1913041334Name(xbc1913041334Name);
            library.setXbc1913041334Price(xbc1913041334Price);
            //MultipartFile photo=os.getFile("file").getName();
            library.setPhoto(photo);
            ILibraryService.addLibrary(library);
            System.out.println(library);
            //model.addAttribute("filename",filename);
        } catch (IOException e) {
            e.printStackTrace();
            dealResultMap(false,"上传失败");
        }
        dealResultMap(true,"上传成功");
        return "redirect:/library/table";
    }

    private  Map<String,Object> dealResultMap(boolean success,String msg){
        Map<String ,Object> result=new HashMap<String,Object>();
        result.put("success",success);
        result.put("msg",msg);
        return result;
    }

    @GetMapping("/upload/page1")
    public String uploadPage1() {
        return "/file/upload1";
    }
    @PostMapping("/upload/multipart1")
    @ResponseBody
// 使用Spring MVC的MultipartFile类作为参数
    public Map<String, Object> upload1(@RequestParam("photo") MultipartFile[] photos) {
        String path = "D:/photo/";
        System.out.println(photos.length);
        for (MultipartFile photo : photos) {
            if (!photo.isEmpty()) {
                // String filename=photos[i].getOriginalFilename();
                String filename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                String suffix =photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
                if (!suffix.equals(".png")) {
                    return dealResultMap(false, "上传失败");
                    // throw new RuntimeException("无效的图片格式");
                }
                try {
                    FileCopyUtils.copy(photo.getInputStream(), new FileOutputStream(path + filename + suffix));
                } catch (IOException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                    return dealResultMap(false, "上传失败");
                }
            }
        }
        return dealResultMap(true, "上传成功");
    }
}



