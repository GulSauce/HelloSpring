package org.swmaestro.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Member Model for JPA
 *
 * @since	2022-06-29
 * @author	ywkim
 */
@Entity
@Table(name = "member")
@Data
@EqualsAndHashCode(callSuper=false)
public class Member extends BaseModel {

    @Id
    private String id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String name;

    private String email;

    private String phone;

}
