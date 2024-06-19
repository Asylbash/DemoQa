package com.demoqa.pages_raznye_stranicy_get;

import lombok.*;
import org.testng.annotations.BeforeClass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoQA {

    public AlertPage alertPage;
    public ButtonsPage buttonsPage;
    public MenuPage menuPage;
    public PracticeFormPage practiceFormPage;
    public ProgressBarPage progressBarPage;
    public SelectMenuPage selectMenuPage;
    public TextBoxPage textBoxPage;
    public WebTablePage webTablePage;
    public DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        textBoxPage = new TextBoxPage();
        practiceFormPage = new PracticeFormPage();
        alertPage = new AlertPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        selectMenuPage = new SelectMenuPage();
        webTablePage = new WebTablePage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
    }

}
