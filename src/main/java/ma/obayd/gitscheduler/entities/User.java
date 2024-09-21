package ma.obayd.gitscheduler.entities;

import java.util.Date ;
import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(
    name = "users" ,
    indexes = {
        @Index(columnList = "username" , name = "idx_username") ,
        @Index(columnList = "email" , name = "idx_email")
    }


)
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence" , sequenceName = "user_id_seq")
    private Long id ;

    @Column(unique = true)
    private String username ;

    @Column(unique = true)
    private String email ;

    @Column(name = "password")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String passwd ;

    @CreationTimestamp
    private Date createAt ;

    @UpdateTimestamp
    private Date updatedAt ;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Token> tokens ;
}
