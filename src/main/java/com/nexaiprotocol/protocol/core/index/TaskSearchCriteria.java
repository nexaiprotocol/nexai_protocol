package com.nexaiprotocol.protocol.core.index;

import lombok.Data;

import java.util.Date;

/**
 * TaskSearchCriteria Class
 * <p>
 * Represents the criteria for searching tasks.
 *
 * @since 1.0
 */
@Data
public class TaskSearchCriteria {
    private String taskType;
    private TaskStatus status;
    private Date startDate;
    private Date endDate;
}
