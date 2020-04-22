package com.example.EmployeeMgmt.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.example.EmployeeMgmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EmployeeMgmt.Exception.EmployeeNotFoundException;
import com.example.EmployeeMgmt.Exception.RecordNotFoundException;
import com.example.EmployeeMgmt.repository.EmployeeLeaveRequestRepository;
import com.example.EmployeeMgmt.repository.EmployeeLeavesRepository;
import com.example.EmployeeMgmt.repository.EmployeeNoticeRepository;
import com.example.EmployeeMgmt.repository.EmployeeHrRequestRepository;
import com.example.EmployeeMgmt.repository.EmployeeRepository;
import com.example.EmployeeMgmt.repository.HRRepository;
import com.example.EmployeeMgmt.model.HR;

@Service
public class HRService {

	Date CompanyfreeAvailableStart=new Date(2020,1,10);
	Date CompanyfreeAvailableEnd=new Date(2020,2,18);
	static int counterVal=100;
	@Autowired
	private EmployeeLeaveRequestRepository leaverepo;
	@Autowired
	private HRRepository hrrepo;
	@Autowired
	private EmployeeNoticeRepository empnotrepo;
	@Autowired
	SequenceGeneratorService seqserve;
	@Autowired 
	EmployeeRepository emprepo;
	@Autowired
	EmployeeLeavesRepository leavesaverepo;
	@Autowired
	EmployeeHrRequestRepository emphrrepo;
	
	public List<HR> getHr()
	{
		return hrrepo.findAll();
	}
	public boolean validatePhoneNumber(String phone)
	{
	        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
	        Matcher m = p.matcher(phone); 
	        return (m.find() && m.group().equals(phone)); 
	   
	}
	public boolean validateEmail(String email)
	{
		String emr = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
				"[a-zA-Z0-9_+&*-]+)*@" + 
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
				"A-Z]{2,7}$"; 
				
		Pattern pat = Pattern.compile(emr); 
		if (email == null) 
			return false; 
		return pat.matcher(email).matches(); 
	}
	public String ValidateEmpChangeInfo(String hr_id,String id) throws EmployeeNotFoundException
	{
		List<EmployeeHrRequest> emptemp=emphrrepo.findAll().stream().filter(s->s.getFromEmpID().equals(id)).filter(s->s.getToHRID().equals(id)).collect(Collectors.toList());
		if(emptemp.size()==0)
			throw new EmployeeNotFoundException("Employee to validate emp not found:-"+id);	
		EmployeeHrRequest emprequest=emptemp.get(0);
		String phno=emprequest.getPhone();
		String email=emprequest.getEmail();
		Optional<Employee> emp=emprepo.findById(id);
		if(!emp.isPresent())
			throw new EmployeeNotFoundException("Employee to validate emp not found:-"+id);
		Employee emp2=emp.get();
		EmployeeNotice empNotice=new EmployeeNotice(hr_id,id);
		empNotice.setId(seqserve.generateNoticeSequence(EmployeeNotice.SEQUENCE_NAME));
		if(validatePhoneNumber(phno)&&validateEmail(email))
		{
			emp2.setPhone(phno);
			emp2.setEmail(email);
			emprepo.deleteById(id);
			emprepo.save(emp2);
			empNotice.setMessage("Your Request for email and phone change has been successfully processed");
			empnotrepo.save(empNotice);
			return "Details verified as correct";
		}
		else
		{	empNotice.setMessage("Your phone or email combination is wrong "+
		"\n please make sure you have phone number Country code  with +91"+
				"Your Email with optional _ @ special chars only ");
			empnotrepo.save(empNotice);
			return "Details Verified as Wrong";
		}
		
			
	}
	public List<EmployeeHrRequest> viewAllEmpHrReqs()
	{
		return emphrrepo.findAll();
	}
	public String genProgressReport(String hR_id, String id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		EmployeeNotice empNotice=new EmployeeNotice(hR_id,id);
		empNotice.setId(seqserve.generateNoticeSequence(EmployeeNotice.SEQUENCE_NAME));
		EmployeeLeaves currentempleave=viewEmployeeLeaveByid(id);
		empNotice.setMessage("Your Progress report has been generated .."+
		"\nFrom : "+hR_id+
		"\nProgress Report of Employee Id :"+id+
		"\nYou are doing great!!"+
		"\n Your applied leaves :"+currentempleave.getLeaves_applied()+
		"\n Your approved leaves :"+currentempleave.getLeaves_approved()+
		"\n Your leaves left :"+currentempleave.getLeaves_left());
		empnotrepo.save(empNotice);
		return "Progress Report Generated";	
	}
		
	
	public List<com.example.EmployeeMgmt.model.EmployeeLeaveRequest> viewLeaveReqApplicationByHrId(String id)
	{		
		List<com.example.EmployeeMgmt.model.EmployeeLeaveRequest> strm=leaverepo.findAll().stream().filter(s->s.toHRID.equals(id)).collect(Collectors.toList());
		
		return strm;		
	}	
	public com.example.EmployeeMgmt.model.EmployeeLeaveRequest viewLeaveReqApplicationByHrAndEmpId(String hR_id, String emp_id) throws RecordNotFoundException {

		List<com.example.EmployeeMgmt.model.EmployeeLeaveRequest> strm=leaverepo.findAll().stream().filter(s->s.toHRID.equals(hR_id)).filter(s->s.fromEmpID.equals(emp_id)).collect(Collectors.toList());
		if(strm.size()==0)
			throw new RecordNotFoundException("Record not found :Employee id-"+emp_id);
		return strm.get(0);
	}
	public EmployeeLeaves viewEmployeeLeaveByid(String id) throws EmployeeNotFoundException {
		
		EmployeeLeaves temp;
		List<EmployeeLeaves> empl= leavesaverepo.findAll().stream().filter(s->s.getEmpId().equals(id)).collect(Collectors.toList());
		if(empl.size()==0)
		{
			Employee emp=viewEmployeeById(id);
			temp=new EmployeeLeaves(id,emp.getName(),5,0,0);
		   leavesaverepo.save(temp);
		   return temp;
		}
		return empl.get(0);
		
	}
	public List<Employee> viewAllEmployees()
	{
		return emprepo.findAll();
	}
	public Employee viewEmployeeById(String id) throws EmployeeNotFoundException
	{
		Optional emp=emprepo.findById(id);
		if(!emp.isPresent())
			throw new EmployeeNotFoundException("Employee not found id-"+id);
		return (Employee) emp.get();
	}
	@Transactional
	public void deleteLeaveApplicationById(String id)
	{
		leaverepo.deleteById(id);
	}
	public String validateLeave(String HR_id,String id) throws RecordNotFoundException, EmployeeNotFoundException
	{
		String status="Not Approved";
		com.example.EmployeeMgmt.model.EmployeeLeaveRequest userLeave=viewLeaveReqApplicationByHrAndEmpId(HR_id,id);
		
		EmployeeNotice empNotice;
		EmployeeLeaves currentempleave=viewEmployeeLeaveByid(id);
		System.out.println(currentempleave.toString());
		Employee emp=viewEmployeeById(id);
		currentempleave.setLeaves_applied(currentempleave.getLeaves_applied()+1);
		empNotice=new EmployeeNotice(HR_id,id);
		empNotice.setId(seqserve.generateNoticeSequence(EmployeeNotice.SEQUENCE_NAME));
		if(userLeave.getLeave_start().after(CompanyfreeAvailableStart)&&userLeave.getLeave_end().before(CompanyfreeAvailableEnd)&&currentempleave.getLeaves_left()>0)
		{
			empNotice.setMessage("Your Leave Request is Approved m8.");
			empnotrepo.save(empNotice);
			currentempleave.setLeaves_approved(currentempleave.getLeaves_approved()+1);
			currentempleave.setLeaves_left(currentempleave.getLeaves_left()-1);
			leavesaverepo.deleteById(currentempleave.getId());
			currentempleave.setId(seqserve.generateLeaveSequence(EmployeeNotice.SEQUENCE_NAME));
			leavesaverepo.save(currentempleave);
			status="Approved";
		}
		else
		{		
			leavesaverepo.deleteById(currentempleave.getId());
			currentempleave.setId(seqserve.generateLeaveSequence(EmployeeNotice.SEQUENCE_NAME));
//			leavesaverepo.save(currentempleave);
			empNotice.setMessage("Your Leave Request is Rejected ,Please Contact your HR.");
			empnotrepo.save(empNotice);
			status="Rejected";
		}
		deleteLeaveApplicationById(userLeave.getLeaveID());
		return "validation "+status;
	}
	
	
	//---------test functionalities by storing
	
	public void reset()
	{
		leavesaverepo.deleteAll();
		leaverepo.deleteAll();
		empnotrepo.deleteAll();
		emphrrepo.deleteAll();
		
		
	}
	public void testSaveLeaveEmp()
	{
		leaverepo.deleteAll();
		com.example.EmployeeMgmt.model.EmployeeLeaveRequest empl=new com.example.EmployeeMgmt.model.EmployeeLeaveRequest("1843798","10001",10,new Date(2020,1,10),new Date(2020,1,20));
		empl.setLeaveID("44");
		leaverepo.save(empl);
		com.example.EmployeeMgmt.model.EmployeeLeaveRequest empl2=new com.example.EmployeeMgmt.model.EmployeeLeaveRequest("1843799","10001",10,new Date(2020,2,10),new Date(2020,2,20));
		empl2.setLeaveID("45");
		leaverepo.save(empl2);
		com.example.EmployeeMgmt.model.EmployeeLeaveRequest empl3=new com.example.EmployeeMgmt.model.EmployeeLeaveRequest("1843717","10002",2,new Date(2020,1,11),new Date(2020,1,13));
		empl3.setLeaveID("46");
		leaverepo.save(empl3);	
	}
	public void testAddHr()
	{
		hrrepo.deleteAll();
		hrrepo.save(new HR(seqserve.generateLeaveSequence(HR.SEQUENCE_NAME),0,"Boby","root","123456789","boby@gmail.com","northindia"));
		hrrepo.save(new HR(seqserve.generateLeaveSequence(HR.SEQUENCE_NAME),1,"Deol","root","987654321","deol@gmail.com","southindia"));
		hrrepo.save(new HR(seqserve.generateLeaveSequence(HR.SEQUENCE_NAME),1,"tarru","root","987654321","deol@gmail.com","Eastindia"));
	}

	public void testSaveEmp() {
		emprepo.deleteAll();
		emprepo.save(new Employee("1843799",1,"taran",new Date(2020,1,16),"root","918231111","taranrishit1234@gmail.com","Systems Engineer",7f,"Good","Full_priv?","Hyderabad"));
		emprepo.save(new Employee("1843798",1,"taran",new Date(2020,1,16),"root","918231111","taranrishit1234@gmail.com","Systems Engineer",7f,"Good","Full_priv?","Hyderabad"));
		emprepo.save(new Employee("1843717",1,"taran",new Date(2020,1,16),"root","918231111","taranrishit1234@gmail.com","Systems Engineer",7f,"Good","Full_priv?","Hyderabad"));
		emprepo.save(new Employee(1,"taran",new Date(2020,1,16),"root","918231111","taranrishit1234@gmail.com","Systems Engineer",7f,"Good","Full_priv?","Hyderabad"));
		emprepo.save(new Employee(1,"Rishit",new Date(2020,1,16),"root","918231111","taranrishit1234@gmail.com","Systems Engineer",7f,"Good","Full_priv?","Hyderabad"));
		emprepo.save(new Employee(1,"undru",new Date(2020,1,16),"root","918231111","taranrishit1234@gmail.com","Systems Engineer",7f,"Good","Full_priv?","Hyderabad"));
	}
	public void testSaveEmpInfo()
	{
		emphrrepo.deleteAll();
		emphrrepo.save(new EmployeeHrRequest("101","1843798","10001","9182314137","taranrishit1234@gmail.com"));
		emphrrepo.save(new EmployeeHrRequest("102","1843799","10001","18937982","taranrishit1234@bebebebeee"));
		
	}

	
}
