package ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import libraryapp.Author;
import libraryapp.Book;
import libraryapp.Genre;
import sqlrequest.AuthorSQL;
import sqlrequest.BookSQL;
import sqlrequest.GenreSQL;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */

	@Theme("mytheme")
	public class MyUI extends UI {
		
		private AuthorSQL aSQL = new AuthorSQL();
		private BookSQL bSQL = new BookSQL();
		private GenreSQL gSQL = new GenreSQL();
	    private TextField filterText = new TextField();
	    private Grid<Book> gridB = new Grid<Book>();
	    private Grid<Author> gridA = new Grid<Author>();
	    private Grid<Genre> gridG = new Grid<Genre>();
		 @Override
		    protected void init(VaadinRequest vaadinRequest) {
		        final VerticalLayout layout = new VerticalLayout();
		        filterText.setPlaceholder("filter by ...");
		        filterText.addValueChangeListener(e -> updateList());
		        filterText.setValueChangeMode(ValueChangeMode.LAZY);
		        
		        Button clearFilterTextBtn = new Button();
		        clearFilterTextBtn.setDescription("Clear the filter");
		        clearFilterTextBtn.addClickListener(e -> filterText.clear());
		        


		        Button button = new Button("Click Me");
		        button.addClickListener( e -> {
		            layout.addComponent(new Label());
		        });
		        
		        
		        
		        setContent(layout);
		        gridA.setColumns("name", "surname", "fathername");
		        gridB.setColumns("title", "city", "year", "coop");
		        gridG.setColumns("type");
		        gridA.setVisible(false);
		        HorizontalLayout main = new HorizontalLayout(gridA,gridB, gridG);
		        layout.addComponents(button, main);

		    }

		    private Object updateList() {
			
			return null;
		}

			@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
		    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
		    public static class MyUIServlet extends VaadinServlet {
		    }
}
	
	

