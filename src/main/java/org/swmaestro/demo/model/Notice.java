package org.swmaestro.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Notice Model for JPA
 *
 * @since	2024-05-02
 * @author	oh youngje
 */
@Entity
@Table(name = "notice")
@Data
@EqualsAndHashCode(callSuper=false)
public class Notice extends BaseModel {

    @Id
    private String id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String subject;

    private String memberId;

    private String content;

}
