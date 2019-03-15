package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTagDate extends SimpleTagSupport {
    private String color;
    private String size;

    public void doTag() throws JspException, IOException {
        if (color != null && size != null) {
            JspWriter out = getJspContext().getOut();
            out.write(String.format("<span style=\"color: %s; font-size: %s;\">%s</span>", color, size, getDateNow()));
        }
    }

    private String getDateNow() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        return ft.format(dNow);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
