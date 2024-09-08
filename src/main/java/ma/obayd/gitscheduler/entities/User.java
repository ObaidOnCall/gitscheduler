package ma.obayd.gitscheduler.entities;

import java.util.Date ;
import java.util.List;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    
    @Id
    private int id ;

    @Column(unique = true)
    private String username ;

    @Column(unique = true)
    private String email ;


    @CreationTimestamp
    private Date createAt ;

    @UpdateTimestamp
    private Date updatedAt ;

    @OneToMany(mappedBy = "account" , cascade = CascadeType.ALL)
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Token> tokens ;
}
