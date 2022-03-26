//package com.example.xbc1913041334library.xbc1913041334Dao.impl;
//
//import com.example.xbc1913041334library.xbc1913041334Dao.ILibraryDao;
//import com.example.xbc1913041334library.xbc1913041334Pojo.Library;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.List;
//@Repository
//public class xbc1913041334LibraryDaoImpl implements ILibraryDao {
//    private List<Library> libraries=new ArrayList<Library>();
//    public xbc1913041334LibraryDaoImpl(){
//        super();
//        libraries.add(new Library(1,"book1",42,"4.png"));
//        libraries.add(new Library(2,"book2",24,"4.png"));
//        libraries.add(new Library(3,"book3",53,"4.png"));
//    }
//
//    @Override
//    public Library getLibrary(Integer xbc1913041334Id) {
//        for (Library library:libraries){
//            if (library.getXbc1913041334Id()==xbc1913041334Id){
//                return library;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Library> showAllLibrary() {
//
//        return libraries;
//    }
//
//    @Override
//    public Boolean addLibrary(Library library) {
//        Boolean flag=false;
//        System.out.println(library.getXbc1913041334Name()+">>"+library.getXbc1913041334Price());
//        libraries.add(library);
//        flag=true;
//        return null;
//    }
//
//    @Override
//    public List<Library> findLibrary(String xbc1913041334Name, Integer xbc1913041334Price) {
//        List<Library> filter =new ArrayList<Library>();
//        if(xbc1913041334Name==null||xbc1913041334Name.trim().equals("")
//                ||xbc1913041334Price==null){
//            filter=libraries;
//        }else {
//            for(Library library:libraries){
//                if (library.getXbc1913041334Name().equals(xbc1913041334Name)&&library.getXbc1913041334Price().equals(xbc1913041334Price))
//                    filter.add(library);
//            }
//        }
//        return filter;
//    }
//
//    @Override
//    public Boolean updateLibrary(Library library) {
//        return false;
//    }
//
//    @Override
//    public Integer deleteLibrary(Integer xbc1913041334Id) {
//        return null;
//    }
//
//    @Override
//    public Boolean insertPhoto(Integer xbc1913041334Id,@RequestParam("photo")  String photo) {
//        Boolean flag=false;
//        for (Library library:libraries){
//            if (library.getXbc1913041334Id()==xbc1913041334Id){
//                photo= photo;
//            }
//        }
//        flag=true;
//        return null;
//    }
//}
