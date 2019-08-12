package com.zhaoshijie.domain.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Demo class
 *
 * @author Zhao Shijie
 * @date 2019/08/12
 */
@Entity
@Data
@Table(name = "USER_TAB")
public class User {

    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    private String uuid;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NICK_NAME")
    private String nickName;
}
