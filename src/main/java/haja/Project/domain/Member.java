package haja.Project.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Column(name = "phone_num")
    private String phone_num;

    @Column(name = "part")
    private String part;

    @Column(name = "comment")
    private String comment;

    @Column(name = "major")
    private String major;

    @Column(name = "student_id")
    private String student_id;

    @Builder
    public Member(Long id, String email, String password, Authority authority, String phone_num, String part, String comment, String major, String student_id) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authority = authority;
        this.phone_num = phone_num;
        this.part = part;
        this.comment = comment;
        this.major = major;
        this.student_id = student_id;
    }
/*

    @Builder
    public Member(String email, String password, Authority authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }
*/
}