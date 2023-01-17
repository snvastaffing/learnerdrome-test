package com.snva.learnerdromeappw.learnerdrome.model.dbmodel;

import lombok.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "user")
public class User {
    @Id
    String _id;
    @Indexed
    String firstName;
    String lastName;
    @Indexed
    String email;
    String contact;
    String profilePicture;
    @DBRef()
    List<Role> roles;
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
