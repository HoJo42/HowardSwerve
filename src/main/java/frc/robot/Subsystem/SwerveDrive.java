package frc.robot.Subsystem;


import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveDrive extends SubsystemBase {
    private SwerveDriveKinematics m_kinematics;
    private SwerveModule[] m_swerveModules;
    private Gyro m_gyro;

    public SwerveDrive(Gyro gyro){
        m_kinematics = new SwerveDriveKinematics(
                                                Constants.frontLeftLocation, 
                                                Constants.frontRightLocation, 
                                                Constants.backLeftLocation, 
                                                Constants.backRightLocation
                                                );

        m_gyro = gyro;
    }

   
    /**
     * Drives the robot from ChassisSpeeds
     * 
     * @param speeds Robot centric ChassisSpeeds object
     */
    public void drive(ChassisSpeeds speeds){

        speeds = ChassisSpeeds.fromFieldRelativeSpeeds(speeds, m_gyro.getRotation2d());

        SwerveModuleState[] moduleStates = m_kinematics.toSwerveModuleStates(speeds);

        for (int i = 0; i < moduleStates.length; i++){
            m_swerveModules[i].setState(moduleStates[i]);
        }
    }
}
