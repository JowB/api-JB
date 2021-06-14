package com.jb.apijb.contact;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class ContactDTO {

    private long id;
    private String address;
    private String phoneNumber;
    private String email;
    private String linkedinUrl;
    private String gitlabUrl;
    private String githubUrl;
}
