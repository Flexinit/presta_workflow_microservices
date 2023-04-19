package com.prestacapital.WorkflowAutomator.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class DocumentTypes {
    @Id
    @SequenceGenerator(
            name = "doc_sequence",
            sequenceName = "doc_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "doc_sequence"
    )
    @ApiModelProperty(hidden = true)
    public Long id;
    public String documentTypeCode;
    public String documentTypeName;
    public String documentTypeDescription;
    @ApiModelProperty(hidden = true)
    public Date createdAt;
}
