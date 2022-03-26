package com.example.xbc1913041334library.xbc1913041334Dao;

import com.example.xbc1913041334library.xbc1913041334Pojo.Library;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface ILibraryDao {
    public Library getLibrary(Integer xbc1913041334Id);
    public List<Library> showAllLibrary();
    public Boolean addLibrary(Library library);
    public Library findLibrary(String xbc1913041334Name,Integer xbc1913041334Price);
    public Boolean updateLibrary(Library library);
    public Integer deleteLibrary(Integer xbc1913041334Id);
    public Boolean insertPhoto(Integer xbc1913041334Id,@RequestParam("photo") String photo);
    public Integer countId(Library library);
    public int count(Map<String, Object> param);
    List<Library> selectPageResult(Map<String, Object> param);
}
