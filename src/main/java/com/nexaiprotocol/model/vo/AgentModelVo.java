package com.nexaiprotocol.model.vo;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @since 1.0
 */

@Data
public class AgentModelVo implements Serializable {


    /**
     * Account name
     */
    private String email;

    /**
     * Account address
     */
    private String address;

    /**
     * Agent name
     */
    private String name;

    /**
     * Agent name
     */
    private String age;

    /**
     * Agent name
     */
    private String gender;


    /**
     * Agent name
     */
    private String country;

    /**
     * Agent name
     */
    private List<String> hobbies;

    /**
     * Agent voice
     */
    private String voice;

    /**
     * Agent bio
     */
    private List<String> bio;

    /**
     * Agent attributes
     */
    private List<String> attr;

    /**
     * Agent lore
     */
    private List<String> lore;

    /**
     * Agent task
     */
    private List<String> task;
}
