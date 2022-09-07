package model;

public class HealthCheckLogic {

	public void execute(Health health) {

		//BMI計算
		int weight = health.getWeight();
		int height = health.getHeight();
		double bmi = weight / (height / 100.0 * height / 100.0);
		bmi = Math.round(bmi * 100) / 100.0;	//小数第2位を四捨五入
		health.setBmi(bmi);

		//BMI数値から体型を判定して設定
		String bodyType;
		if (bmi < 18.5) {
			bodyType = "痩せ型";
		} else if (bmi < 25) {
			bodyType = "普通";
		} else {
			bodyType = "肥満";
		}
		health.setBodyType(bodyType);
	}
}
