package za.co.etalente.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INVESTOR")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Investor {

    @Id
    @Column(name = "INVESTOR_ID", unique = true)
    private Integer investorId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    //Remove and Build Own Object - contact - email - tel
    @Column(name = "CONTACT_NO")
    private String contact;

    //Remove and build entity -
    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "AGE")
    private Integer age;

    //
    @JoinColumn(name = "INVESTOR_ID")
    @OneToMany
    private Set<Product> products = new HashSet<>();
}
