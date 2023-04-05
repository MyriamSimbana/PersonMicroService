package com.example.demo.domain.dto;

import com.example.demo.domain.dto.validation.Identification;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    @Identification
    String identification;

    @NonNull
    @Size(min = 0, max=10,message = "Type identification incorrect")
    @JsonProperty("IdentificationType")
    String identificationType;

    @NotBlank(message = "Is mandatory")
    String phoneNumber;

    @Builder.Default
    boolean active = true;

    @Range(min = 0, max = 100,message = "Salary dont accepted")
    Float salary;

    @Email
    String email;
}
