package com.prestacapital.WorkflowAutomator.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class ApprovalRequest {
    @Id
    @SequenceGenerator(
            name = "approval_sequence",
            sequenceName = "approval_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "approval_sequence"
    )
    //@JsonIgnore
    @ApiModelProperty(hidden = true)
    public Long id;
    public String requestId; //Used for tracking by requesting entity
    public Long documentTypeId;
    public String firstName;
    public String LastName;
    public String approvalStep;
    public String phoneNumber;
    public String emailAddress;

    @ApiModelProperty(hidden = true)
    @Builder.Default
    public Boolean approved = false;
    public String IDNumber;
    public String description;
    @ApiModelProperty(hidden = true)
    public Date createdAt;
    public String createdBy;

}
