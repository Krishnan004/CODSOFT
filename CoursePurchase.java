package NumberGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoursePurchase extends Frame {
    private List courseList;
    private TextArea selectedCourses;
    private TextField totalCostField;
    private Button purchaseButton;

    private ArrayList<Course> courses;
    private ArrayList<Course> selectedCoursesList;
    private double totalCost = 0;

    public CoursePurchase() {
        courses = new ArrayList<>();
        selectedCoursesList = new ArrayList<>();

        // Sample courses
        courses.add(new Course("Java Programming", 100));
        courses.add(new Course("Python Programming", 120));
        courses.add(new Course("Web Development", 150));
        courses.add(new Course("Data Science", 200));

        // GUI setup
        courseList = new List();
        for (Course course : courses) {
            courseList.add(course.getName() + " - $" + course.getPrice());
        }

        selectedCourses = new TextArea(5, 30);
        selectedCourses.setEditable(false);
        totalCostField = new TextField(30);
        totalCostField.setEditable(false);
        purchaseButton = new Button("Purchase");

        setLayout(new FlowLayout());
        add(new Label("Select Course:"));
        add(courseList);
        add(new Label("Selected Courses:"));
        add(selectedCourses);
        add(new Label("Total Cost:"));
        add(totalCostField);
        add(purchaseButton);

        setSize(800, 800);
        setVisible(true);

        // Event handling
        courseList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = courseList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Course selectedCourse = courses.get(selectedIndex);
                    selectedCoursesList.add(selectedCourse);
                    updateSelectedCourses();
                    updateTotalCost();
                }
            }
        });

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!selectedCoursesList.isEmpty()) {
                    StringBuilder receipt = new StringBuilder("Purchase Successful!\n\nSelected Courses:\n");
                    for (Course course : selectedCoursesList) {
                        receipt.append(course.getName()).append(" - $").append(course.getPrice()).append("\n");
                    }
                    receipt.append("\nTotal Cost: $").append(totalCost);
                    selectedCourses.setText(receipt.toString());
                    selectedCoursesList.clear();
                    totalCost = 0;
                    totalCostField.setText("");
                } else {
                    selectedCourses.setText("No courses selected.");
                }
            }
        });
    }

    private void updateSelectedCourses() {
        StringBuilder courseDetails = new StringBuilder();
        for (Course course : selectedCoursesList) {
            courseDetails.append(course.getName()).append(" - $").append(course.getPrice()).append("\n");
        }
        selectedCourses.setText(courseDetails.toString());
    }

    private void updateTotalCost() {
        totalCost = 0;
        for (Course course : selectedCoursesList) {
            totalCost += course.getPrice();
        }
        totalCostField.setText("$" + totalCost);
    }

    public static void main(String[] args) {
        new CoursePurchase();
    }

    class Course {
        private String name;
        private double price;

        public Course(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
