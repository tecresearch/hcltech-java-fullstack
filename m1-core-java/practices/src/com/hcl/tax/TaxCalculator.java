package com.hcl.tax;

public class TaxCalculator {
	private float basicSalary;
	private boolean citizenship;

	public TaxCalculator(float basicSalary, boolean citizenship) {
		super();
		this.basicSalary = basicSalary;
		this.citizenship = citizenship;
	}

	public float calculateTax() {
		float tax = 30 * (basicSalary / 100);
		return tax;
	}

	public int deductTax(float tax) {
		int netSalary = (int) (basicSalary - tax);
		return netSalary;
	}

	public boolean validateSalary(int basicSalary, boolean citizenship) {
		if (basicSalary > 100000 && citizenship == true) {
			return true;
		}
		return false;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public boolean isCitizenship() {
		return citizenship;
	}

	public void setCitizenship(boolean citizenship) {
		this.citizenship = citizenship;
	}

}
