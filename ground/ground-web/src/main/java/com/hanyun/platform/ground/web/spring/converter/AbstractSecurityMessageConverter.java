package com.hanyun.platform.ground.web.spring.converter;

import com.hanyun.platform.ground.util.security.AESEncoder;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 * </pre>
 * <p/>
 * Date: 15/4/23
 * Time: 14:38
 *
 * @author heroin.nee@gmail.com
 */
@SuppressWarnings("WeakerAccess")
public abstract class AbstractSecurityMessageConverter<T> extends AbstractHttpMessageConverter<T> {

    public static final String CHARSET = "UTF-8";

    protected String cryptoKey;

    protected AbstractSecurityMessageConverter() {
    }

    protected AbstractSecurityMessageConverter(MediaType supportedMediaType) {
        setSupportedMediaTypes(Collections.singletonList(supportedMediaType));
    }

    protected AbstractSecurityMessageConverter(MediaType... supportedMediaTypes) {
        setSupportedMediaTypes(Arrays.asList(supportedMediaTypes));
    }

    protected InputStream getSecurityBody(HttpInputMessage inputMessage) throws IOException {
        InputStream src = inputMessage.getBody();
        List<String> keys = inputMessage.getHeaders().get("Content-Crypto-Type");
        if (null != keys && !keys.isEmpty()) {
            // 遍历是什么类型的加密
            String result = AESEncoder.decrypt(IOUtils.toString(src, CHARSET), getCryptoKey());
            assert result != null;
            return IOUtils.toInputStream(result, CHARSET);
        } else {
            return src;
        }
    }

    public String getCryptoKey() {
        return cryptoKey;
    }

    public void setCryptoKey(String cryptoKey) {
        this.cryptoKey = cryptoKey;
    }
}
