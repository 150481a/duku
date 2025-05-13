package org.duku.mall.framework.starter.common.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.common.utils.Base64DecodeMultipartFile;

import java.io.InputStream;

/**
 * 序列化的input stream
 *
 * @author Chopper
 */
@Data
@NoArgsConstructor
public class SerializableStream {
    private String base64;

    public SerializableStream(InputStream inputStream) {
        this.base64 = Base64DecodeMultipartFile.inputStreamToStream(inputStream);
    }

}
 
