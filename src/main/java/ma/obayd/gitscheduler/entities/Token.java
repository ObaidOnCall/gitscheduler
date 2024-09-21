package ma.obayd.gitscheduler.entities;

import java.util.Date;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.obayd.gitscheduler.enums.TokenType;


@Entity
@Table(
    name = "tokens" ,
    indexes = {
        @Index(columnList = "privateKey" , name = "idx_privateKey")
    }
)
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Token {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Enumerated(EnumType.ORDINAL)
    private TokenType type = TokenType.MASTER ;

    @Column(columnDefinition = "JSON")
    private String acl ;

    @Column(unique = true , updatable = false , length = 64)
    private String privateKey ;

    @CreationTimestamp
    private Date createAt ;

    @UpdateTimestamp
    private Date updatedAt ;

    private Date expireAt ;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    private User user ;
}
