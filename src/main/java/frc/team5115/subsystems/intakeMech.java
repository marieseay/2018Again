package frc.team5115.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;

import static frc.team5115.robot.Robot.joy;

public class intakeMech {
    public DoubleSolenoid leftAbove;
    public DoubleSolenoid rightAbove;
    public DoubleSolenoid leftBelow;
    public DoubleSolenoid rightBelow;
    public DoubleSolenoid arm;

    public Spark leftIntake;
    public Spark rightIntake;

    public intakeMech()
    {
        leftBelow = new DoubleSolenoid(7, 0, 1);
        rightBelow = new DoubleSolenoid(7, 2,3);
        leftAbove = new DoubleSolenoid(7,7,6);
        rightAbove = new DoubleSolenoid(7,4,5);
        arm = new DoubleSolenoid(8, 1, 0);

//        leftIntake = new Spark(4);
//        rightIntake = new Spark(4);
    }

    public void intakeUp()
    {
        if(joy.getRawButton(4)) {
            leftAbove.set(DoubleSolenoid.Value.kForward);
            rightAbove.set(DoubleSolenoid.Value.kForward);
        } else {
            intakeStill();
        }
    }

    public void intakeDown()
    {
        if(joy.getRawButton(5)) {
            leftAbove.set(DoubleSolenoid.Value.kReverse);
            rightAbove.set(DoubleSolenoid.Value.kReverse);
        } else {
            intakeStill();
        }
    }

    public void intakeStill()
    {
        arm.set(DoubleSolenoid.Value.kOff);
        leftAbove.set(DoubleSolenoid.Value.kOff);
        rightAbove.set(DoubleSolenoid.Value.kOff);
        leftBelow.set(DoubleSolenoid.Value.kOff);
        rightBelow.set(DoubleSolenoid.Value.kOff);
    }

    public void intakeOpen()
    {
        if(joy.getRawButton(8)) {
            leftBelow.set(DoubleSolenoid.Value.kForward);
            rightBelow.set(DoubleSolenoid.Value.kForward);

            leftAbove.set(DoubleSolenoid.Value.kForward);
            rightAbove.set(DoubleSolenoid.Value.kForward);
        } else {
            intakeStill();
        }
    }

    public void intakeClose()
    {
        if(joy.getRawButton(6)) {
            leftBelow.set(DoubleSolenoid.Value.kReverse);
            rightBelow.set(DoubleSolenoid.Value.kReverse);
        } else {
            intakeStill();
        }
    }

// WHEELIES BROKEN
//    public void intakeWheelie()
//    {
//        leftIntake.set(1);
//        rightIntake.set(1);
//    }
//
//    public void intakeWheelieOff()
//    {
//        leftIntake.set(0);
//        rightIntake.set(0);
//    }
}
