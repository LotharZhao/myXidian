package com.zhao.iii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		EmpManage em = new EmpManage();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 菜单
		while (true) {
			System.out.println("请选择要进行的操作：");
			System.out.println("1.添加员工  " + "2.查找员工 " + "3.修改工资 " + "4.删除员工 "
					+ "0.退出");

			String operType = br.readLine();
			if (operType.equals("0")) {
				System.out.println("结束操作！");
				System.exit(0);
			} else if (operType.equals("1")) {
				System.out.println("请输入编号：");
				String empNo = br.readLine();
				System.out.println("请输入名字：");
				String name = br.readLine();
				System.out.println("请输入工资：");
				float salary = Float.parseFloat(br.readLine());

				Emp emp = new Emp(empNo, name, salary);
				em.addEmp(emp);
				System.out.println("添加成功！");
			} else if (operType.equals("2")) {
				System.out.println("请输入编号：");
				String empNo = br.readLine();

				em.showEmp(empNo);
			} else if (operType.equals("3")) {
				System.out.println("请输入编号：");
				String empNo = br.readLine();
				System.out.println("请输入新工资：");
				float newSal = Float.parseFloat(br.readLine());

				em.updateSal(empNo, newSal);
				System.out.println("修改成功！");
			} else if (operType.equals("4")) {
				System.out.println("请输入编号：");
				String empNo = br.readLine();

				em.removeEmp(empNo);
				System.out.println("删除成功！");
			} else
				System.out.println("输入错误，请重新输入！");
		}
	}
}

class EmpManage {
	private ArrayList al = null;

	// 构造函数
	public EmpManage() {
		al = new ArrayList();
	}

	// 添加员工
	public void addEmp(Emp emp) {
		al.add(emp);
	}

	// 查询员工-员工号
	public void showEmp(String empNo) {
		for (int i = 0; i < al.size(); i++) {
			Emp temp = (Emp) al.get(i);
			if (temp.getEmpNo().equals(empNo)) {
				System.out.println(temp.getEmpNo() + "-" + temp.getName() + "-"
						+ temp.getSalary());
				break;
			}
		}
	}

	// 修改工资
	public void updateSal(String empNo, float newSal) {
		for (int i = 0; i < al.size(); i++) {
			Emp temp = (Emp) al.get(i);
			if (temp.getEmpNo().equals(empNo)) {
				temp.setSalary(newSal);
				break;
			}
		}
	}

	// 删除员工
	public void removeEmp(String empNo) {
		for (int i = 0; i < al.size(); i++) {
			Emp temp = (Emp) al.get(i);
			if (temp.getEmpNo().equals(empNo)) {
				al.remove(temp);// al.remove(i);
				break;
			}
		}
	}
}

class Emp {
	private String empNo;
	private String name;
	private float salary;

	public Emp(String empNo, String name, float salary) {
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}