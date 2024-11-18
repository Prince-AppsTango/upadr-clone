package com.app.upadrapp.utils

import androidx.compose.ui.graphics.Color

data class PrepStep(
    val stepNumber: String,
    val timing: String,
    val description: String,
)

val prepSteps = listOf(
    PrepStep(
        stepNumber = "Step 1",
        timing = "3 days before procedure",
        description = "Prepare yourself by following any specific dietary instructions provided by your doctor. Avoid high-fiber foods."
    ),
    PrepStep(
        stepNumber = "Step 2",
        timing = "2 days before procedure",
        description = "Continue the dietary restrictions. Focus on drinking plenty of water to stay hydrated. Review the procedure checklist."
    ),
    PrepStep(
        stepNumber = "Step 3",
        timing = "1 day before procedure",
        description = "Switch to a clear liquid diet. Avoid solid food. Begin taking the prep solution as directed by your doctor."
    ),
    PrepStep(
        stepNumber = "Step 4",
        timing = "Night before procedure",
        description = "Complete the first part of your prep solution if split dosing is recommended. Stay close to a restroom."
    ),
    PrepStep(
        stepNumber = "Step 5",
        timing = "Morning of procedure",
        description = "Complete the remaining prep solution if applicable. Avoid any food or drink unless specifically allowed by your doctor."
    ),
    PrepStep(
        stepNumber = "Step 6",
        timing = "Arriving at the clinic",
        description = "Bring any required documents, including ID and insurance information. Ensure you have a ride arranged post-procedure."
    ),
    PrepStep(
        stepNumber = "Step 7",
        timing = "During the procedure",
        description = "Relax and let the medical team guide you through the process. Your comfort and safety are their priority."
    ),
    PrepStep(
        stepNumber = "Step 8",
        timing = "After the procedure",
        description = "Rest and recover at home. Follow post-procedure dietary instructions and resume regular activities as advised."
    ),
    PrepStep(
        stepNumber = "Step 9",
        timing = "1 day after procedure",
        description = "Contact your doctor if you experience any discomfort. Gradually reintroduce normal foods into your diet."
    ),
    PrepStep(
        stepNumber = "Step 10",
        timing = "Follow-up appointment",
        description = "Schedule or attend a follow-up appointment to discuss the procedure results and next steps, if any."
    )
)
