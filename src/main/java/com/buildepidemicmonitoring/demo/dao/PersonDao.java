package com.buildepidemicmonitoring.demo.dao;


import com.buildepidemicmonitoring.demo.entry.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface PersonDao {
    @Insert("insert into Person(id,image,temperature) values(#{id},#{image},#{temperature})")
    int insertPerson(Person person);

    @Select("select*from User where id=#{id} and image=#{image} and temperature=#{temperature}")
    Person selectByPersonIdAndtemperatureAndImage(int id, float temperature, MultipartFile image);

    @Select("select*from Person where id=#{id}")
    Person selectByPersonId(float id);

    @Select("select*from Person where image=#{image}")
    Person selectByPersonImage(MultipartFile image);
}
