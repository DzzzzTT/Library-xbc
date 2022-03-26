package com.example.xbc1913041334library.xbc1913041334Service;

import com.example.xbc1913041334library.xbc1913041334Pojo.Library;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface ILibraryService {
    public Library getLibrary(Integer xbc1913041334ID);
    public List<Library> showAllLibrary();
    public Boolean addLibrary(Library library);
    //public List<Library> findLibrary(String xbc1913041334Name,Integer xbc1913041334Price);
    public Library findLibrary(String xbc1913041334Name,Integer xbc1913041334Price);
    public Boolean insertPhoto(Integer xbc1913041334Id,@RequestParam("photo") String photo);
    public Boolean updateLibrary(Library library);
    public Integer deleteLibrary(Integer xbc1913041334Id);
    public Integer checkId(Library library);
    public int count(Map<String, Object> param);
    public List<Library> getPageResult(Map<String, Object> param);
}
