package com.prestacapital.WorkflowAutomator.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@Entity
@Table
public class Approvers {
    @Id
    @SequenceGenerator(
            name = "approver_sequence",
            sequenceName = "approver_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "approver_sequence"
    )

    @ApiModelProperty(hidden = true)
    public Long id;//public String approverId;
    public String firstName;
    public String lastName;
    public String emailAddress;
    public String phoneNumber;
    public String designation;
    public Long documentTypeId;
    @ApiModelProperty(hidden = true)
    public Date createdAt;
}
