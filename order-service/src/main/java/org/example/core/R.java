package org.example.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 5/9/2022 10:18 上午
 * 描述：
 *
 * @author grant
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private String requestId;
    private String code;
    private String message;
    private String data;
}
