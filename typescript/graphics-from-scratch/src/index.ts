import * as BABYLON from "@babylonjs/core";

//<reference path="babylon.math.ts"/>
namespace SoftEngine {
  export class Camera {
    Position: BABYLON.Vector3;
    Target: BABYLON.Vector3;

    constructor() {
      this.Position = BABYLON.Vector3.Zero();
      this.Target = BABYLON.Vector3.Zero();
    }
  }
  export class Mesh {
    Position: BABYLON.Vector3;
    Rotation: BABYLON.Vector3;
    Vertices: BABYLON.Vector3[];

    constructor(public name: string, verticesCount: number) {
      this.Vertices = new Array(verticesCount);
      this.Rotation = BABYLON.Vector3.Zero();
      this.Position = BABYLON.Vector3.Zero();
    }
  }
}

// class Device {
//   private workingCanvas: HTMLCanvasElement;
//   private workingWidth: number;
//   private workingHeight: number;
//   private workingContext: CanvasRenderingContext2D;
//   private backbuffer!: ImageData;
//   private backbufferdata!: Uint8ClampedArray;

//   /**
//    * Initializes a new Device.
//    * @param {HTMLCanvasElement} canvas The canvas element to use for rendering.
//    */
//   constructor(canvas: HTMLCanvasElement) {
//     this.workingCanvas = canvas;
//     this.workingWidth = canvas.width;
//     this.workingHeight = canvas.height;
//     this.workingContext = this.workingCanvas.getContext("2d")!;
//   }

//   public clear(): void {
//     this.workingContext.clearRect(0, 0, this.workingWidth, this.workingHeight);
//     this.backbuffer = this.workingContext.getImageData(
//       0,
//       0,
//       this.workingWidth,
//       this.workingHeight
//     );
//   }

//   public present(): void {
//     this.workingContext.putImageData(this.backbuffer, 0, 0);
//   }

//   public putPixel(x: number, y: number, color: BABYLON.Color4): void {
//     this.backbufferdata = this.backbuffer.data;
//     const index: number =
//       (Math.floor(x) + Math.floor(y) * this.workingWidth) * 4;

//     this.backbufferdata[index] = color.r * 255;
//     this.backbufferdata[index + 1] = color.g * 255;
//     this.backbufferdata[index + 2] = color.b * 255;
//     this.backbufferdata[index + 3] = color.a * 255;
//   }

//   public project(
//     coord: BABYLON.Vector3,
//     transMat: BABYLON.Matrix
//   ): BABYLON.Vector2 {
//     const point = BABYLON.Vector3.TransformCoordinates(coord, transMat);
//     const x = point.x * this.workingWidth + this.workingWidth / 2.0;
//     const y = -point.y * this.workingHeight + this.workingHeight / 2.0;
//     return new BABYLON.Vector2(x, y);
//   }

//   public drawPoint(point: BABYLON.Vector2): void {
//     if (
//       point.x >= 0 &&
//       point.y >= 0 &&
//       point.x < this.workingWidth &&
//       point.y < this.workingHeight
//     ) {
//       this.putPixel(point.x, point.y, new BABYLON.Color4(1, 1, 0, 1));
//     }
//   }

//   public render(camera: BABYLON.Camera, meshes: BABYLON.Mesh[]): void {
//     const viewMatrix = BABYLON.Matrix.LookAtLH(
//       camera.position,
//       camera.target,
//       BABYLON.Vector3.Up()
//     );
//     const projectionMatrix = BABYLON.Matrix.PerspectiveFovLH(
//       0.78,
//       this.workingWidth / this.workingHeight,
//       0.01,
//       1.0
//     );

//     for (const mesh of meshes) {
//       const worldMatrix = BABYLON.Matrix.RotationYawPitchRoll(
//         mesh.rotation.y,
//         mesh.rotation.x,
//         mesh.rotation.z
//       ).multiply(
//         BABYLON.Matrix.Translation(
//           mesh.position.x,
//           mesh.position.y,
//           mesh.position.z
//         )
//       );

//       const transformMatrix = worldMatrix
//         .multiply(viewMatrix)
//         .multiply(projectionMatrix);

//       for (const vertex of mesh.getVerticesData(
//         BABYLON.VertexBuffer.PositionKind
//       )!) {
//         const projectedPoint = this.project(vertex as any, transformMatrix);
//         this.drawPoint(projectedPoint);
//       }
//     }
//   }
// }

// let canvas: HTMLCanvasElement;
// let device: Device;
// let meshes: BABYLON.Mesh[] = [];
// let camera: BABYLON.TargetCamera;

// window.onload = () => {
//   canvas = document.getElementById("frontBuffer") as HTMLCanvasElement;

//   const mesh = new BABYLON.Mesh("Cube", null);
//   const vertices = [
//     new BABYLON.Vector3(-1, 1, 1),
//     new BABYLON.Vector3(1, 1, 1),
//     new BABYLON.Vector3(-1, -1, 1),
//     new BABYLON.Vector3(1, -1, 1),
//     new BABYLON.Vector3(-1, 1, -1),
//     new BABYLON.Vector3(1, 1, -1),
//     new BABYLON.Vector3(1, -1, -1),
//     new BABYLON.Vector3(-1, -1, -1),
//   ];
//   mesh.setVerticesData(
//     BABYLON.VertexBuffer.PositionKind,
//     new Float32Array(vertices.flatMap((v) => [v.x, v.y, v.z]))
//   );
//   meshes.push(mesh);

//   camera = new BABYLON.TargetCamera(
//     "camera",
//     new BABYLON.Vector3(0, 0, 10),
//     undefined
//   );
//   camera.target = BABYLON.Vector3.Zero();

//   device = new Device(canvas);

//   requestAnimationFrame(drawingLoop);
// };

// function drawingLoop() {
//   device.clear();

//   for (const mesh of meshes) {
//     mesh.rotation.x += 0.01;
//     mesh.rotation.y += 0.01;
//   }

//   device.render(camera, meshes);
//   device.present();

//   requestAnimationFrame(drawingLoop);
// }
