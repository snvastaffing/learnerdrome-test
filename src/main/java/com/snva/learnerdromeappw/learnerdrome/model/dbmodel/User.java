package com.snva.learnerdromeappw.learnerdrome.model.dbmodel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class User {

    String _id;

    String firstName;
    String lastName;

    String email;
    String contact;
    String profilePicture;

    List<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", roles=" + roles +
                '}';
    }
//    @DBRef()
//    List<Education> educations;
//    @DBRef()
//    List<Experience> experiences;
//    @DBRef()
//    List<Technology> technologies;
//    @DBRef()
//    List<ProgrammingLanguage> programmingLanguages;
//    @DBRef()
//    List<SocialMedia> socialMedia;
}
