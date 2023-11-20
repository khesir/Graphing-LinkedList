import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

import src.Graph;

/**
 * MainApp
 */
public class MainApp {
    static Graph graph = new Graph();

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){
            GenerateData(new FileReader("graph.txt"));
            DisplayData();
        }catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
    public static void DisplayData(){
        graph.printGraph();
    }
    public static void GenerateData(FileReader fr){
        try(Scanner sc = new Scanner(fr)){
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(" ");
                
                if(data.length > 1){
                    graph.addEdge(data[0], data[2]);
                }else{
                    graph.addNode(data[0]);
                }
            }
            System.out.println("Data has been loaded to the list");
        } catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
}