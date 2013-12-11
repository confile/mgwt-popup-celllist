package test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;

public class ItemCell implements Cell<Item> {

	private static Template TEMPLATE = GWT.create(Template.class);

    public interface Template extends SafeHtmlTemplates {
        @SafeHtmlTemplates.Template("<div>{0}</div>")
        SafeHtml content(String cellContents);
    }

    @Override
    public void render(SafeHtmlBuilder safeHtmlBuilder, Item model) {
        SafeHtml content = TEMPLATE.content(model.getName());

        safeHtmlBuilder.append(content); 

    }

    @Override
    public boolean canBeSelected(Item model) {
        return true;
    }

}
