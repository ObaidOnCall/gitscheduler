package ma.obayd.gitscheduler.entities;

import java.util.Date;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import ma.obayd.gitscheduler.enums.TokenType;


@Setter @Getter
public class Token {
    
    @Id
    private int id ;

    @Column(columnDefinition = "VARCHAR(64) UNIQUE")
    private String key ;

    @Enumerated
    private TokenType type ;

    @Column(columnDefinition = "JSON")
    private String acl ;

    @CreationTimestamp
    private Date createAt ;

    @UpdateTimestamp
    private Date updatedAt ;

    private Date expireAt ;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    private User user ;
}
