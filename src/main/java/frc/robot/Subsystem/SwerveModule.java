package frc.robot.Subsystem;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveModule extends SubsystemBase {

    private MotorController m_speed;
    private CANSparkMax m_rotation;

    private AnalogEncoder m_encoder;
    private PIDController m_anglePID;

    public SwerveModule(){

    }

    /**Optimizes and sets the state
     * @param swerveModuleState field centric state
     */
    public void setState(SwerveModuleState swerveModuleState) {

        SwerveModuleState.optimize(swerveModuleState, new Rotation2d(getEncoderAsRadians()));

        if (swerveModuleState.speedMetersPerSecond >= Constants.maxWheelSpeed) {
            m_speed.set(1);
        } else {
            m_speed.set(swerveModuleState.speedMetersPerSecond / Constants.maxWheelSpeed);
        }
        
        double pidOutput = m_anglePID.calculate(getEncoderAsRadians(), swerveModuleState.angle.getRadians());

        m_rotation.set(pidOutput);
    }

    private double getEncoderAsRadians() { //TODO: Finish this
        return m_encoder.getAbsolutePosition();
    }

    public void setAngle() {}
}
