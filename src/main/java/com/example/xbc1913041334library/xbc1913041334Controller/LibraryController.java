package com.example.xbc1913041334library.xbc1913041334Controller;

import com.example.xbc1913041334library.framework.Result;
import com.example.xbc1913041334library.framework.ResultBean;
import com.example.xbc1913041334library.framework.ResultUtil;
import com.example.xbc1913041334library.xbc1913041334Pojo.Library;
import com.example.xbc1913041334library.xbc1913041334Service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("library")
public class LibraryController {

    @Autowired
    private ILibraryService libraryService;

    @GetMapping("book")
    public String book(){
        return "book";
    }

    @RequestMapping("/getLibrary")
    @ResponseBody
    public ModelAndView getLibrary(Integer xbc1913041334Id){
        Library library=libraryService.getLibrary(xbc1913041334Id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/library/details");
        mv.addObject("library",library);
        return mv;
    }

    @RequestMapping("/getLibrary1")
    @ResponseBody
    public Library getLibrary1(Integer xbc1913041334Id){
        Library library= libraryService.getLibrary(xbc1913041334Id);
        return library;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Library> list(){
        List<Library> libraries=new ArrayList<Library>();
        libraries = libraryService.showAllLibrary();
        return libraries;
    }

    @RequestMapping("/details1")
    public ModelAndView showAllLibrary() {
        List<Library> libraries = new ArrayList<Library>();
        libraries = libraryService.showAllLibrary();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/library/details1");
        mv.addObject("library1", libraries);
        return mv;
    }

    @GetMapping("add")
    public String add(){
        return "/library/add";
    }

//    @PostMapping("/insert")
//    @ResponseBody
//    public Library insert(@RequestBody Library library){
//        libraryService.addLibrary(library);
//        return library;
//    }

    @PostMapping("/insert")
    @ResponseBody
    public  ModelAndView insert(@RequestParam("xbc1913041334Id") Integer xbc1913041334Id,
                                @RequestParam("xbc1913041334Name") String xbc1913041334Name,
                                @RequestParam("xbc1913041334Price") Integer xbc1913041334Price,
                                @RequestParam("photo") MultipartFile photo) {
        String path = "D:/photo/";
        String filename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date() );
        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
        Library library = new Library(xbc1913041334Id,xbc1913041334Name,xbc1913041334Price, filename + suffix);
        try {
            FileCopyUtils.copy(photo.getInputStream(),new FileOutputStream(path + filename + suffix));
        }catch (Exception e) {
            e.printStackTrace();
        }
        libraryService.addLibrary(library);
        return this.table();
    }

    @RequestMapping("/photo/{url}")
    @ResponseBody
    public void readPartImage(HttpServletRequest request, HttpServletResponse response, @PathVariable("url") String url)
            throws Exception {
        String path = "D:/photo/";
        File file = new File(path + url);
        InputStream is = new FileInputStream(file);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        OutputStream os = response.getOutputStream();

        int xbc = 0;
        while (-1 != (xbc = is.read())) {
            bs.write(xbc);
        }
        os.write(bs.toByteArray());
        is.close();
        bs.close();
        os.close();
    }

    //7. 通过URL传递参数，{ ...}表明参数的位置和名称。该例指定名称为id
    @RequestMapping("/{xbc1913041334Id}")
    // 响应为JSON数据集
    @ResponseBody
    // @PathVariable 通过参数名称获取参数
    public Library getLibrary2(@PathVariable("xbc1913041334Id") Integer xbc1913041334Id) {
        return libraryService.getLibrary(xbc1913041334Id);
    }



    /**  9.EasyUI框架 ——进入首页面，查询所有的用户
     * @return table.jsp页面
     */
    @RequestMapping("table")
    public ModelAndView table() {
        List<Library> libraries=libraryService.showAllLibrary();
        System.out.println(libraries);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/library/table");
        mv.addObject("libraryList", libraries);
        return mv;
    }

    @RequestMapping("list3")
    @ResponseBody
    public List<Library> list3(
            @RequestParam(value="xbc1913041334Name",required=false)
                    String xbc1913041334Name,
            @RequestParam(value="xbc1913041334Price",required=false)
                    Integer xbc1913041334Price) {
        Library library=libraryService.findLibrary(xbc1913041334Name, xbc1913041334Price);
        List<Library> libraries = new ArrayList<>();
        libraries.add(new Library(library.getXbc1913041334Id(),
                library.getXbc1913041334Name(),
                library.getXbc1913041334Price(),
                "<img  src="+"http://localhost:8081/"+"pic/"+library.getPhoto()+" height="+"50px"+" width="+"50px"+">"));
        System.out.println(libraries);
        return libraries;
    }


    @GetMapping("/list1")
    public ResultBean<List<Library>> getPageResult(
            @RequestParam(required = false) Integer xbc1913041334Id ,
            @RequestParam(required = false) String xbc1913041334Name,
            @RequestParam(required = false) Integer xbc1913041334Price,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {

        Map<String, Object> param = new HashMap<>(16);

        // 计算起始行号
        int offset = (page - 1) * limit;
        int rows = limit;

        param.put("xbc1913041334Id",xbc1913041334Id);
        param.put("xbc1913041334Name",xbc1913041334Name);
        param.put("xbc1913041334Price",xbc1913041334Price);
        param.put("offset", offset);
        param.put("rows", rows);

        // 统计记录数
        int totalRows = libraryService.count(param);

        // 获取当前页结果集
        List<Library> entities = libraryService.getPageResult(param);

        return new ResultBean<>(0, "查询成功", totalRows, entities);

    }
    @GetMapping("/bookEdit/{xbc1913041334Id}")
    public String libraryEdit(@PathVariable Integer xbc1913041334Id, Model model){
        Library library = libraryService.getLibrary(xbc1913041334Id);
        model.addAttribute("library",library);

        return "bookEdit";
    }


    @GetMapping("/bookDetail/{xbc1913041334Id}")
    public String library(@PathVariable Integer xbc1913041334Id, Model model){
        Library library = libraryService.getLibrary(xbc1913041334Id);
        model.addAttribute("library",library);

        return "bookDetail";
    }

    @RequestMapping("/delete/{xbc1913041334Id}")
    @ResponseBody
    public String delete(@PathVariable("xbc1913041334Id")Integer xbc1913041334Id ) {
        return "删除数据["+libraryService.deleteLibrary(xbc1913041334Id)+"]条";

    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateBook(
            @RequestParam(value = "xbc1913041334Id")Integer xbc1913041334Id,
            @RequestParam(value = "xbc1913041334Name")String xbc1913041334Name,
            @RequestParam(value = "xbc1913041334Price")Integer xbc1913041334Price) {

        Library library=new Library();
        library.setXbc1913041334Id(xbc1913041334Id);
        library.setXbc1913041334Name(xbc1913041334Name);
        library.setXbc1913041334Price(xbc1913041334Price);
        return "更新【"+libraryService.updateLibrary(library)+"】条数据";
    }
    @RequestMapping("update")
    public ModelAndView update(@RequestParam(value = "xbc1913041334Id",required=false) Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("library/update");
        Library library=libraryService.getLibrary(id);

        mv.addObject("library",library);
        return mv;
    }

    @RequestMapping("/update1")
    @ResponseBody
    public  ModelAndView update(@RequestParam(value = "xbc1913041334Id")Integer xbc1913041334Id,
                                @RequestParam(value = "xbc1913041334Name")String xbc1913041334Name,
                                @RequestParam(value = "xbc1913041334Price")Integer xbc1913041334Price,
                                @RequestParam(value="photo") MultipartFile photo) {
        String path = "D:/photo/";
        String filename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date() );
        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
        Library library=libraryService.getLibrary(xbc1913041334Id);
        library.setXbc1913041334Id(xbc1913041334Id);
        library.setXbc1913041334Name(xbc1913041334Name);
        library.setXbc1913041334Price(xbc1913041334Price);
        library.setPhoto(filename + suffix);
        try {
            FileCopyUtils.copy(photo.getInputStream(),new FileOutputStream(path + filename + suffix));
        }catch (Exception e) {
            e.printStackTrace();
        }
        libraryService.updateLibrary(library);
        return table();
    }

    @RequestMapping("delete")
    public ModelAndView deleteBook(@RequestParam(value="xbc1913041334Id", required=false) Integer xbc1913041334Id){
        Integer id= Integer.valueOf(xbc1913041334Id);
        Boolean flag = false;
        if(libraryService.deleteLibrary(xbc1913041334Id)!=0) {
            flag=true;
        }

        return table();
    }

}
