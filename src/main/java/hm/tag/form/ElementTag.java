package hm.tag.form;

import javax.servlet.jsp.JspException;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.tags.form.AbstractHtmlElementTag;
import org.springframework.web.servlet.tags.form.TagWriter;

/**
 * カスタムタグ<form2:element>の実体クラス。
 */
@SuppressWarnings("serial")
public class ElementTag extends AbstractHtmlElementTag {
    
    /**
     * カスタムタグの属性「element」の値。
     * ・出力するタグ名を保持する
     * ・ただし、属性「elementError」が指定されていればその値を利用する。
     */
    private String element;
    
    /**
     * カスタムタグの属性「elementError」の値。
     * ・エラー時に出力するタグ名を保持する
     */
    private String elementError;
    
    /**
     * カスタムタグの属性「outIfError」の値。
     * ・エラー時にしか出力しないかどうかのフラグ。
     */
    private boolean outIfError;
    
    private TagWriter tagWriter;
    
    @Override
    protected int writeTagContent(final TagWriter tagWriter) throws JspException {
        
        this.tagWriter = tagWriter;
        if(outIfError && !getBindStatus().isError()) {
            // エラー時のみにしか出力しない場合、処理を終了。
            return EVAL_BODY_INCLUDE;
        }
        
        if(getBindStatus().isError()) {
            if(StringUtils.hasLength(getElementError())) {
                tagWriter.startTag(getElementError());
            } else {
                tagWriter.startTag(getElement());
            }
        } else {
            tagWriter.startTag(getElement());
        }
        
        // 属性の設定
        writeDefaultAttributes(tagWriter);
        
        // 開始タグの出力
        tagWriter.forceBlock();
        
        return EVAL_BODY_INCLUDE;
    }
    
    @Override
    public int doEndTag() throws JspException {
        
        if(outIfError && !getBindStatus().isError()) {
            // エラー時のみにしか出力しない場合、処理を終了。
            return EVAL_PAGE;
        }
        
        
        // 終了タグの出力
        this.tagWriter.endTag();
        return EVAL_PAGE;
    }
    
     @Override
    protected String getName() throws JspException {
        // This also suppresses the 'id' attribute (which is okay for a <label/>)
        return null;
    }
    
    @Override
    protected String resolveId() throws JspException {
        Object id = evaluate("id", getId());
        if (id != null) {
            return super.resolveId();
        }
        return null;
    }

    
    public String getElement() {
        return element;
    }
    
    public void setElement(String element) {
        this.element = element;
    }
    
    public String getElementError() {
        return elementError;
    }
    
    public void setElementError(String elementError) {
        this.elementError = elementError;
    }
    
     public boolean isOutIfError() {
        return outIfError;
    }
    
    public void setOutIfError(boolean outIfError) {
        this.outIfError = outIfError;
    }
}