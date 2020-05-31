/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haitham.springbootapp;

import com.haitham.springbootapp.models.Course;
import com.haitham.springbootapp.models.Registration;
import com.haitham.springbootapp.models.Studant;
import com.haitham.springbootapp.repositories.CourseRepository;
import com.haitham.springbootapp.repositories.RegistrationRepository;
import com.haitham.springbootapp.repositories.StudantRepository;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author Haitham
 */
@Component
public class ChfxController implements Initializable {

    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TextField txtcourseid;
    @FXML
    private TextField semester;
    @FXML
    private TextField txtstudentid;
    @FXML
    private TableView<Studant> TableViewStudant;
    @FXML
    private TableColumn<Studant, Integer> tableID;
    @FXML
    private TableColumn<Studant, String> tableName;
    @FXML
    private TableColumn<Studant, String> tableMajor;
    @FXML
    private TableColumn<Studant, Double> tableGrade;
    @FXML
    private TableView<Registration> TableViewRegistr;
    @FXML
    private TableColumn<Registration, Integer> idreg;
    @FXML
    private TableColumn<Registration, Integer> tableStudantID;
    @FXML
    private TableColumn<Registration, Integer> tableCourseID;
    @FXML
    private TableColumn<Registration, String> tableSemester;
    @FXML
    private Button Show;
    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button addReg;
    @FXML
    private Button sotfeng;
    @FXML
    private Button excellent;
    @FXML
    private Button passStudents;
    @FXML
    private Button computerScience;

    @Autowired
    StudantRepository studantRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableID.setCellValueFactory(new PropertyValueFactory("id"));
        tableName.setCellValueFactory(new PropertyValueFactory("name"));
        tableMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tableGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        /////////////////////////////////////////////////////////////
        idreg.setCellValueFactory(new PropertyValueFactory("id"));
        tableStudantID.setCellValueFactory(new PropertyValueFactory("studantid"));
        tableCourseID.setCellValueFactory(new PropertyValueFactory("courseid"));
        tableSemester.setCellValueFactory(new PropertyValueFactory("semester"));
        ////////////////////////////////////////////////////////////
        TableViewStudant.getSelectionModel().selectedItemProperty().addListener(
                event -> show_selected());

    }

    @FXML
    private void showHandle(ActionEvent event) {
        List<Studant> students = studantRepository.findAll();
        TableViewStudant.getItems().setAll(students);
        List<Registration> registrations = registrationRepository.findAll();
        TableViewRegistr.getItems().setAll(registrations);
        reset();
    }

    @FXML
    private void addHandle(ActionEvent event) {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        Studant student = new Studant();
        student.setId(id);
        student.setName(name);
        student.setMajor(major);
        student.setGrade(grade);
        studantRepository.save(student);
        reset();
    }

    @FXML
    private void updateHandle(ActionEvent event) {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        boolean exist = studantRepository.existsById(id);
        if (exist == true) {
            Studant student = studantRepository.findById(id).get();
            student.setName(name);
            student.setMajor(major);
            student.setGrade(grade);
            studantRepository.save(student);
        }
    }

    @FXML
    private void deleteHandle(ActionEvent event) {
      Integer id = Integer.parseInt(txtFieldID.getText());
       boolean exist = studantRepository.existsById(id);
       if (exist == true) {
            Studant student = studantRepository.findById(id).get(); 
            studantRepository.delete(student);
       }
    }

    @FXML
    private void addRegHandle(ActionEvent event) {
        Integer id_course = Integer.parseInt(txtcourseid.getText());
        Integer id_student = Integer.parseInt(txtstudentid.getText());
        Studant student = studantRepository.findById(id_student).get();
        Course course = courseRepository.findById(id_course).get();
        String Semester = semester.getText();
        Registration registration = new Registration();
        registration.setStudantid(student);
        registration.setCourseid(course);
        registration.setSemester(Semester);
        registrationRepository.save(registration);
        reset();
    }

    @FXML
    private void softengHandle(ActionEvent event) {
        String major = "Software Engineering";
        List<Studant> students = studantRepository.findAll();
         List<Studant> students_major = new ArrayList<>();
        for(Studant std: students){ 
        if(std.getMajor().equals(major)){ 
        students_major.add(std);
        TableViewStudant.getItems().setAll(students_major);
        reset();
        }
      }
    }

    @FXML
    private void excellentHandle(ActionEvent event) {
        Double grade = 90.0;
         List<Studant> students = studantRepository.findAll();
         List<Studant> students_grade = new ArrayList<>();
        for(Studant std: students){ 
        if(std.getGrade()>=grade){ 
        students_grade.add(std);
        TableViewStudant.getItems().setAll(students_grade);
        reset();
        }
      } 
        
    }

    @FXML
    private void passStudentsHandle(ActionEvent event) {
        Double grade = 50.0;
        List<Studant> students = studantRepository.findAll();
         List<Studant> students_grade = new ArrayList<>();
        for(Studant std: students){ 
        if(std.getGrade()>=grade){ 
        students_grade.add(std);
        TableViewStudant.getItems().setAll(students_grade);
        reset();
        }
      }    
    }

    @FXML
    private void computerScienceHandle(ActionEvent event) {
        Double grade = 70.0;
        String major = "Computer Science";
        List<Studant> students = studantRepository.findAll();
        for(Studant std: students){ 
        if(std.getGrade()<grade &&std.getMajor().equals(major)){ 
        std.setGrade(std.getGrade()+3);
        studantRepository.save(std);
        reset();
        }
      }  
    }

    private void reset() {
        txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldMajor.setText("");
        txtFieldGrade.setText("");
        txtcourseid.setText("");
        semester.setText("");
        txtstudentid.setText("");
    }

    private void show_selected() {
        Studant std = TableViewStudant.getSelectionModel().getSelectedItem();
        if (std != null) {
            txtFieldID.setText(String.valueOf(std.getId()));
            txtFieldName.setText(String.valueOf(std.getName()));
            txtFieldMajor.setText(String.valueOf(std.getMajor()));
            txtFieldGrade.setText(String.valueOf(std.getGrade()));
            txtstudentid.setText(std.getId() + "");
        }
    }

}
