package com.example.xbc1913041334library.xbc1913041334Service.xbc1913041334Impl;

import com.example.xbc1913041334library.xbc1913041334Dao.ILibraryDao;
import com.example.xbc1913041334library.xbc1913041334Pojo.Library;
import com.example.xbc1913041334library.xbc1913041334Service.ILibraryService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class xbc1913041334LibraryServiceImpl implements ILibraryService {
    @Autowired
    private ILibraryDao libraryDao;

    @Override
    public Library getLibrary(Integer xbc1913041334ID) {
        return libraryDao.getLibrary(xbc1913041334ID);
    }

    @Override
    public List<Library> showAllLibrary() {
        return libraryDao.showAllLibrary();
    }

    @Override
    public Boolean addLibrary(Library library) {
        /*Library library =new Library();
        library.setXbc1913041334Id(xbc1913041334Id);
        library.setXbc1913041334Name(xbc1913041334Name);
        library.setXbc1913041334Price(xbc1913041334Price);
        library.setPhoto(photo);*/
        return libraryDao.addLibrary(library);
    }

    @Override
    public Library findLibrary(String xbc1913041334Name, Integer xbc1913041334Price) {
        return libraryDao.findLibrary(xbc1913041334Name,xbc1913041334Price);
    }

    @Override
    public Boolean insertPhoto(Integer xbc1913041334Id, String photo) {
        return libraryDao.insertPhoto(xbc1913041334Id,photo);
    }

    @Override
    public Boolean updateLibrary(Library library) {
        return libraryDao.updateLibrary(library);
    }

    @Override
    public Integer deleteLibrary(Integer xbc1913041334Id) {
        return libraryDao.deleteLibrary(xbc1913041334Id);
    }

//    @Override
//    public Boolean modify(Library library) {
//        return libraryDao.updateLibrary(library);
//    }
//
//    @Override
//    public void removes(Integer xbc1913041334Ids) {
//        libraryDao.deleteLibrary(xbc1913041334Ids);
//    }
    public Integer checkId(Library library) {
        return libraryDao.countId(library);
    }
    public int count(Map<String, Object> param) {
        return libraryDao.count(param);
    }
    public List<Library> getPageResult(Map<String, Object> param) {
        return libraryDao.selectPageResult(param);
    }
}
