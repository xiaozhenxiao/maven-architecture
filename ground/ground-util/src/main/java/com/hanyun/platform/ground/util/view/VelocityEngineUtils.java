package com.hanyun.platform.ground.util.view;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Map;

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
 * <p>
 * Date: 14/10/23
 * Time: 20:29
 *
 * @author heroin.nee@gmail.com
 */
@SuppressWarnings("WeakerAccess")
public class VelocityEngineUtils {

    private static final Logger LOG = LoggerFactory.getLogger(VelocityEngineUtils.class);

    private final static String DEFAULT_CHARSET = "UTF-8";
    private final static VelocityEngine engine;

    static {
        engine = new VelocityEngine();
        engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
        engine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_CACHE, "true");
        try {
            engine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH,
                    new File(VelocityEngineUtils.class.getResource("/").toURI().getSchemeSpecificPart()).getAbsolutePath());
        } catch (URISyntaxException e) {
            LOG.error("init error, ", e);
        }
    }

    public static void mergeTemplate(String templateLocation, String encoding, Map model,
                                     Writer writer) {
        mergeTemplate(engine, templateLocation, encoding, model, writer);
    }

    public static void mergeTemplate(VelocityEngine engine, String templateLocation, String encoding,
                                     Map model, Writer writer) {
        try {
            VelocityContext velocityContext = new VelocityContext(model);
            engine.mergeTemplate(templateLocation, encoding, velocityContext, writer);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            LOG.error("Why does VelocityEngine throw a generic checked exception, after all?", ex);
            throw new VelocityException(ex.toString());
        }
    }

    public static String mergeTemplateIntoString(String templateLocation, Map model) {
        return mergeTemplateIntoString(engine, templateLocation, model);
    }

    public static String mergeTemplateIntoString(VelocityEngine engine, String templateLocation,
                                                 Map model) {
        StringWriter result = new StringWriter();
        mergeTemplate(engine, templateLocation, DEFAULT_CHARSET, model, result);
        return result.toString();
    }
}
