package com.zhao.iii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		EmpManage em = new EmpManage();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �˵�
		while (true) {
			System.out.println("��ѡ��Ҫ���еĲ�����");
			System.out.println("1.���Ա��  " + "2.����Ա�� " + "3.�޸Ĺ��� " + "4.ɾ��Ա�� "
					+ "0.�˳�");

			String operType = br.readLine();
			if (operType.equals("0")) {
				System.out.println("����������");
				System.exit(0);
			} else if (operType.equals("1")) {
				System.out.println("�������ţ�");
				String empNo = br.readLine();
				System.out.println("���������֣�");
				String name = br.readLine();
				System.out.println("�����빤�ʣ�");
				float salary = Float.parseFloat(br.readLine());

				Emp emp = new Emp(empNo, name, salary);
				em.addEmp(emp);
				System.out.println("��ӳɹ���");
			} else if (operType.equals("2")) {
				System.out.println("�������ţ�");
				String empNo = br.readLine();

				em.showEmp(empNo);
			} else if (operType.equals("3")) {
				System.out.println("�������ţ�");
				String empNo = br.readLine();
				System.out.println("�������¹��ʣ�");
				float newSal = Float.parseFloat(br.readLine());

				em.updateSal(empNo, newSal);
				System.out.println("�޸ĳɹ���");
			} else if (operType.equals("4")) {
				System.out.println("�������ţ�");
				String empNo = br.readLine();

				em.removeEmp(empNo);
				System.out.println("ɾ���ɹ���");
			} else
				System.out.println("����������������룡");
		}
	}
}

class EmpManage {
	private ArrayList al = null;

	// ���캯��
	public EmpManage() {
		al = new ArrayList();
	}

	// ���Ա��
	public void addEmp(Emp emp) {
		al.add(emp);
	}

	// ��ѯԱ��-Ա����
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

	// �޸Ĺ���
	public void updateSal(String empNo, float newSal) {
		for (int i = 0; i < al.size(); i++) {
			Emp temp = (Emp) al.get(i);
			if (temp.getEmpNo().equals(empNo)) {
				temp.setSalary(newSal);
				break;
			}
		}
	}

	// ɾ��Ա��
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