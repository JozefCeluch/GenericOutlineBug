Example repo for a Compose bug where the Composable is not rendered at all on API 26 if it's clipped to a `Shape` that uses `Outline.Generic`. The 

with `androidx.compose.ui:ui` version `1.7.0-beta03`

| API 28 | API 26 |
|--------|--------|
| ![image](https://github.com/JozefCeluch/GenericOutlineBug/assets/1104656/e72b74d9-9509-4ad8-b89d-dbbfb6781581) | ![image](https://github.com/JozefCeluch/GenericOutlineBug/assets/1104656/a26b13c1-8c3d-40a9-b6fc-ebb8f855c689) |

with `androidx.compose.ui:ui` version `1.6.8`

| API 28 | API 26 |
|--------|--------|
| ![image](https://github.com/JozefCeluch/GenericOutlineBug/assets/1104656/208c993a-1570-4ccf-a183-a112a4275119) | ![image](https://github.com/JozefCeluch/GenericOutlineBug/assets/1104656/cecb8fa8-af68-4f6f-afa5-c63ae65d1474) |
