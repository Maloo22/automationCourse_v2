package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QuizzersListAndTestPage extends BaseMain{

    public QuizzersListAndTestPage (WebDriver driver) {

        super(driver);
    }


    //locators
    String startBTN = "//body[1]/div[1]/div[2]/div[3]/div[2]/div[2]/a[1]";
    String counter = "//body/div[@id='app']/div[2]/div[3]/div[2]/div[2]/div[1]";
    String answerA = "//body/div[@id='app']/div[@class='main-content quiz-process-main-content']/div[@class='quiz-process-right-block']/div[@id='quiz-process-question-block']/div[@id='quiz-process-question-block-answers-block']/div[1]";
    String nextBTN = "//div[contains(@class,'quiz-process-navigations-block-button-next')]";
    String progBar = "//div[@id='quiz-process-progress-data']";
    String answList = "//div[@class='quiz-process-questions']/div";




    public void switchToTestTab (){
        switchToWindow(1);
    }

    public void pressStartBtn () {
        driver.findElement(By.xpath(startBTN)).sendKeys(Keys.ENTER);
    }


    public void takingTotalNum () {
        // Ищем каунтер
        WebElement element = driver.findElement(By.xpath(counter));

        // Получаем текст из каунтера
        String elementText = element.getText();


        // Разделяем строку по символу "/"
        String[] values = elementText.split("/");

        // Обрезаем пробелы в значениях и делаем из стринги инты
        int firstValue = Integer.parseInt(values[0].trim());
        int secondValue = Integer.parseInt(values[1].trim());

        //System.out.println("Первое значение: " + firstValue);
        System.out.println("Второе значение: " + secondValue);
    }


    public void passingTestAndProgressBarValidation () {

            // ПОлучаем все варианты ответов
            List<WebElement> answerOptions = driver.findElements(By.xpath(answList));
            int totalQuestions = answerOptions.size();

            // цикл прохождения по вопросам
            for (int questionIndex = 0; questionIndex < totalQuestions; questionIndex++) {
                // Выбрать ответ
                driver.findElement(By.xpath(answerA)).click();

                WebElement progressBar = driver.findElement(By.xpath(progBar));
                String progressBarText = progressBar.getText();
                int progressPercentage = Integer.parseInt(progressBarText.replace("%", ""));

                // Вычисление ожидаемого процентного значения
                int expectedPercentage = (questionIndex + 1) * 100 / totalQuestions;

                // Сравнение ожидаемого и фактического процентных значений
                if (progressPercentage == expectedPercentage) {
                    System.out.println("Совпало! Прогресс бар имеет значение: " + progressBarText + " данные при ответе на вопрос № " + (questionIndex + 1));
                } else {
                    System.out.println("Не совпало! Должно быть: " + expectedPercentage + "%, Фактическое: " + progressPercentage + "%");
                }
                driver.findElement(By.xpath(nextBTN)).click();

            }

        }
}







