package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    // Find all female students
    @Query(value = "SELECT * FROM ogrenci WHERE cinsiyet = 'K'", nativeQuery = true)
    List<Ogrenci> findGirls();

    // Find distinct class names
    @Query(value = "SELECT DISTINCT sinif FROM ogrenci", nativeQuery = true)
    List<String> findAllClasses();

    // Find female students in class 10A
    @Query(value = "SELECT * FROM ogrenci WHERE sinif = '10A' AND cinsiyet = 'K'", nativeQuery = true)
    List<Ogrenci> find10AGirls();

    // Find female students with ogrno between 5 and 10
    @Query(value = "SELECT * FROM ogrenci WHERE ogrno > 5 AND ogrno < 10 AND cinsiyet = 'K'", nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();

    // Find students sorted alphabetically by name
    @Query(value = "SELECT * FROM ogrenci ORDER BY ad", nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();

    // Find class 10A students sorted by descending ogrno
    @Query(value = "SELECT * FROM ogrenci WHERE sinif = '10A' ORDER BY ogrno DESC", nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();

    // Find youngest student
    @Query(value = "SELECT * FROM ogrenci WHERE dtarih = (SELECT MAX(dtarih) FROM ogrenci)", nativeQuery = true)
    Ogrenci findYoungestStudent();

    // Find oldest student
    @Query(value = "SELECT * FROM ogrenci WHERE dtarih = (SELECT MIN(dtarih) FROM ogrenci)", nativeQuery = true)
    Ogrenci findElderStudent();

    // Find students whose second letter in the name is 'E'
    @Query(value = "SELECT * FROM ogrenci WHERE SUBSTRING(ad, 2, 1) = 'e'", nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();
}
