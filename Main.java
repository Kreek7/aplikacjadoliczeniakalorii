package bucky;

import java.util.stream.Stream;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	double sum1,sum2,sum3,sum4;
	double kalorie;
	TableView<Product> table;
	TextField nameInput, caloriesInput, carbsInput, proteinInput, fatInput ;
	ObservableList<Product> products = FXCollections.observableArrayList();
	

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = new Stage();
		 
		 
		 
		 
		 
	 	window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Aplikacja do liczenia kalorii");
        window.setMinWidth(250);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        
        
        
        
        Label nameLabel1 = new Label("Podaj swoja date urodzenia:");
        GridPane.setConstraints(nameLabel1, 0, 0);
        
        
        TextField nameInput1 = new TextField();
        GridPane.setConstraints(nameInput1, 1, 0);
        
        Label nameLabel2 = new Label("Podaj swoj wzrost:");
        GridPane.setConstraints(nameLabel2, 0, 1);
        
        
        TextField nameInput2 = new TextField();
        GridPane.setConstraints(nameInput2, 1, 1);
        
        Label nameLabel3 = new Label("Podaj swoja wage:");
        GridPane.setConstraints(nameLabel3, 0,2);
        
        
        TextField nameInput3 = new TextField();
        GridPane.setConstraints(nameInput3, 1, 2);
        
        
        
        
        
        Button przycisk = new Button("Oblicz");
        GridPane.setConstraints(przycisk, 0, 4);
        przycisk.setOnAction(e ->{
        obliczanie(nameInput1,nameInput2,nameInput3);
        window.close();
        	
        });
        
        

        
        
        
        grid.getChildren().addAll(nameLabel1,nameInput1,nameLabel2,nameInput2,nameLabel3,nameInput3,przycisk);
        
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();
		
	}
	
	public void obliczanie(TextField nameinput11,TextField nameinput22, TextField nameinput33 ) {
     	
		 
		 
     	String a = nameinput11.getText();
     	String b = nameinput22.getText();
     	String c = nameinput33.getText();
     	
     	
     	int z = Integer.parseInt(a);
     	z = 2017 - z;
     	int x = Integer.parseInt(b);
     	int y = Integer.parseInt(c);
     	
     	
     	Stage window1 = new Stage();
     	
     	kalorie = 66+(13.7*y) + (5*x) - (6.76*z);
     	
     	Label label = new Label();
        label.setText("POWINEŒ SPO¯YWAÆ: " + kalorie + "kalorii");
        
        Button button1 = new Button("Przejdz do licznika kalorii w jedzeniu");
       // TextField nameInput5 = null;
		button1.setOnAction(e -> {
			start();
			window1.close();
			
			
		});
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,button1);
        layout.setAlignment(Pos.CENTER);
        
        
     	
     	
     	Scene scene = new Scene(layout);
     	window1.setScene(scene);
        window1.showAndWait();
     	
     	
     	
     	
     }
	
	public void start()  {
		
		
        Stage window = new Stage();
		window.setTitle("thenewboston - JavaFX");

        //Name column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Nazwa");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));

        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Kalorie");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("kalorie1"));

        //Quantity column
        TableColumn<Product, Double> quantityColumn = new TableColumn<>("Weglowodany");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("weglowodany"));
        
        TableColumn<Product, Double> quantityColumn2 = new TableColumn<>("Bialka");
        quantityColumn2.setMinWidth(100);
        quantityColumn2.setCellValueFactory(new PropertyValueFactory<>("bialka"));
        
        TableColumn<Product, Double> quantityColumn3 = new TableColumn<>("Tluszcze");
        quantityColumn3.setMinWidth(100);
        quantityColumn3.setCellValueFactory(new PropertyValueFactory<>("tluszcze"));
        
        

        //Name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Nazwa");
        nameInput.setMinWidth(100);

        //Price input
        TextField caloriesInput = new TextField();
        caloriesInput.setPromptText("Kalorie");

        //Quantity input
        TextField carbsInput = new TextField();
        carbsInput.setPromptText("Weglowodany");
        
        TextField proteinInput = new TextField();
        proteinInput.setPromptText("Bialka");
        
        TextField fatInput = new TextField();
        fatInput.setPromptText("Tluszcze");

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked(nameInput,caloriesInput,carbsInput,proteinInput,fatInput));
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        Button pieButton = new Button("Statystyki");
        pieButton.setOnAction(e -> statystyki());
        Button checkButton = new Button("Sprawdzanie");
        checkButton.setOnAction(e -> sprawdzenie());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, caloriesInput, carbsInput,proteinInput,fatInput, addButton, deleteButton,pieButton,checkButton);
        
        
       

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn,quantityColumn2,quantityColumn3);
        

        

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(TextField nameInput, TextField priceInput, TextField quantityInput, TextField quantityInput2, TextField quantityInput3){
        Product product = new Product();
        product.setNazwa(nameInput.getText());
        product.setKalorie1(Double.parseDouble(priceInput.getText()));
        product.setWeglowodany(Double.parseDouble(quantityInput.getText()));
        product.setBialka(Double.parseDouble(quantityInput2.getText()));
        product.setTluszcze(Double.parseDouble(quantityInput3.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
        quantityInput2.clear();
        quantityInput3.clear();
        
        
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Serek wiejski",97, 2,11,5));
        products.add(new Product("Banan", 88, 23,1.1,0.3));
        products.add(new Product("Jajko", 155, 1.1,13,11));
        products.add(new Product("Piers z kurczaka", 260, 7,21,19));
        products.add(new Product("Ogórek konserwowy", 10, 2.3,0.3,0.2));
       
        return products;
        
        
        	
    
    }
    
    

	public void statystyki() {
		
		Stage stage = new Stage();
		
		Label label = new Label();
		Label label2 = new Label();
		Label label3 = new Label();
      
		
		 Scene scene = new Scene(new Group());
	        stage.setTitle("Imported Fruits");
	        stage.setWidth(500);
	        stage.setHeight(500);
		
		
		 ObservableList<Product> allProducts;
		 allProducts = table.getItems();
		double sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
    	int sum = table.getItems().size();
    		for (int i=0; i<sum;i++) {
    			
    				sum1 = sum1 + allProducts.get(i).getKalorie1();
    				sum2 = sum2 + allProducts.get(i).getWeglowodany();
    				sum3 = sum3 + allProducts.get(i).getBialka();
    				sum4 = sum4 + allProducts.get(i).getTluszcze();
    				
    		}
    		
    		
    		double suma = sum2+sum3+sum4;
    		double procentw = (sum2*100.0f)/suma;
    		double procentb = (sum3*100.0f)/suma;
    		double procentt = (sum4*100.0f)/suma;
    		
    		
    		ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                    new PieChart.Data("Weglowodany " + Math.round(procentw) + "%", sum2),
                    new PieChart.Data("Bialka " + Math.round(procentb) + '%', sum3),
                    new PieChart.Data("Tluszcze " + Math.round(procentt) + '%', sum4));
            final PieChart chart = new PieChart(pieChartData);
            chart.setTitle("Procentowy wykres wartosci odzywczych");

            ((Group) scene.getRoot()).getChildren().add(chart);
            
            stage.setScene(scene);
            stage.show();
    		
		
		
    		
    		
    	
    	
    }
	
	
	public void sprawdzenie () {
		
		
		
		Stage stage2 = new Stage();
		
		
		
		Label label = new Label();
		Label label2 = new Label();
		Label label3 = new Label();
		
		ObservableList<Product> allProducts;
		 allProducts = table.getItems();
		 int sum = table.getItems().size();
   		for (int i=0; i<sum;i++) {
   			
   				sum1 = sum1 + allProducts.get(i).getKalorie1();
   				sum2 = sum2 + allProducts.get(i).getWeglowodany();
   				sum3 = sum3 + allProducts.get(i).getBialka();
   				sum4 = sum4 + allProducts.get(i).getTluszcze();
   				
   		}
   		if(sum1>kalorie) {
   			label.setText("Kalorie ktore powinienes zjesc : " + Math.round(kalorie));
   			label2.setText("Kalorie ktore zjadles:  " + Math.round(sum1));
   	        label3.setText("Spozyles za duzo kalorii o " + Math.round(sum1-kalorie));
   			
   			
   		}
   		
   		
   		else if (sum1<kalorie) {
   			label.setText("Kalorie ktore powinienes zjesc : " + Math.round(kalorie));
   			label2.setText("Kalorie ktore zjadles:  " +Math.round(sum1));
   			label3.setText("Zjadles za malo. Powinien zjesc jeszcze " +Math.round(kalorie-sum1)  + " kalorii");
   		}
   		
   		VBox vBox = new VBox();
        vBox.getChildren().addAll(label,label2,label3);
        Scene scene = new Scene(vBox);
        stage2.setScene(scene);
        stage2.show();
        
        
   		
   		
   		
		
		
	}
	
    
	
	

}
